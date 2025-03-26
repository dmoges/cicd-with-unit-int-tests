package com.software.testing.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class UserDtoTest {

    @Test
    void myFirstTest() {
      assertThat(1).isEqualTo(1);
    }

}
