FROM openjdk:17-jdk-slim-buster
WORKDIR /app
EXPOSE 8080
COPY ./target/springboot-cicd-unit-int-test-image.jar /app/springboot-cicd-unit-int-test-image.jar
ENTRYPOINT ["java", "-jar", "springboot-cicd-unit-int-test-image.jar"]