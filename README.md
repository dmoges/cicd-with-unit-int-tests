# The Test Series with Spring Boot

##  Built With

1. JDK (17)
2. Spring Boot (3.1.2)
3. Maven 
4. JUnit 5
5. Mockito
6. PostgreSQL / H2 Database

## About the Tests

This project includes the following types of tests:

### Unit Tests
The UnitTestClass in the src/test/java directory contains unit tests for the relevant Java class. These tests isolate individual parts (methods) of the class to verify if each part functions as expected.

### Integration Tests
The IntegrationTestClass in the src/test/java directory contains integration tests for the relevant Java class. These tests verify that different classes interact correctly.

### Sonarquebe in Docker
username: admin
password: sonarAdmin

localhost:9000


mvn clean verify sonar:sonar \
  -Dsonar.projectKey=Unit-and-Integration-Sping-boot-testing \
  -Dsonar.projectName='Unit-and-Integration-Sping-boot-testing' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=sqp_47de997dfb90268ca73ea54a89664ed67f3f52f1



mvn clean verify sonar:sonar -Dsonar.projectKey=Unit-and-Integration-Sping-boot-testing -Dsonar.projectName='Unit-and-Integration-Sping-boot-testing'  -Dsonar.host.url=http://localhost:9000 -Dsonar.token=sqp_47de997dfb90268ca73ea54a89664ed67f3f52f1
=======
### SonarQube
The code will be analysed by SonarQube.

In order to integrate SonarQube to GitHub Actions, SonarQube should be installed and the secret like the SONAR_HOST_URL of the SonarQube Server and the authentication SONAR_TOKEN should be configured on GitHub.

### Create a SONAR TOKEN on SonarQube
Launch the Sonar Server by using the docker-compose file, which is located under "ci" folder in the root directoy, on the docker server.

Usename:    admin
Password:   sonarPwd

Go to the SonarQube Server select the user and Click on the menu "A" and select the menuitem "My Account" and then click the menu item "Security" from the navigation menu.

Under the form Tokens enter the Name, Type and Expiration Date to generate a token.

e.g. 
Name:   maven test project
Type:   User Token
Expires in: 30 Days

and clicke on the button "Generate". 


squ_a13943edb64163c3345111fc5ce74831655e8c0c

Copy the generated token, go to "GitHub", select the repository for Code Analysis, click on "Settings".
And select "Secrets and Variables".

SONAR_TOKEN: 

squ_a13943edb64163c3345111fc5ce74831655e8c0c

SONAR_HOST_URL:

http://192.168.1.8:9000/

### Configure the workflow YAML file

docu of the workflow for maven project:

https://docs.sonarsource.com/sonarqube-server/latest/devops-platform-integration/github-integration/adding-analysis-to-github-actions-workflow/
