package com.software.testing.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import com.software.testing.model.User;
import com.software.testing.repository.UserRepository;

@DataJpaTest
@TestPropertySource(properties = { "spring.test.database.replace=none" })
@Testcontainers
class UserRepositoryIntegrationTest {

    @Container
    // @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
            .withCopyFileToContainer(
                    MountableFile.forClasspathResource("sql/init-db.sql"),
                    "/docker-entrypoint-initdb.d/init-db.sql");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void givenUserEntity_whenSaveUser_thenUserIsPersisted() {
        // given
        User user = new User()
                .setId(11L)
                .setUserName("user")
                .setPassword("password")
                .setEmail("email1");

        // when
        userRepository.save(user);

        // then
        Optional<User> retrievedUser = userRepository.findByEmail("email1");
        assertTrue(retrievedUser.isPresent());
        assertEquals("user", retrievedUser.get().getUserName());
    }
}