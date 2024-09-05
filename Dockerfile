FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
COPY ./target/springboot-cicd-unit-int-test-image.jar springboot-cicd-unit-int-test-image.jar
ENTRYPOINT ["java", "-jar", "springboot-cicd-unit-int-test-image.jar"]