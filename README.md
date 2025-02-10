# Task Management Application

This is a Java-based task management application built with Maven, using Java 17 and MySQL as the database.

## Prerequisites

- **Java 17:** Ensure you have Java 17 installed on your system.
- **MySQL:** Ensure you have MySQL installed and running. Create a database named `task_app` and update the database configurations in the `application.properties` file.

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/yourusername/task-app.git
cd task-app
```
- Set Up MySQL Database
- Create a database named task_app.

- Update the src/main/resources/application.properties file with your MySQL configurations:
```
  spring.datasource.url=jdbc:mysql://localhost:3306/task_app?useSSL=false&serverTimezone=UTC
  spring.datasource.username=your_mysql_username
  spring.datasource.password=your_mysql_password
  spring.jpa.hibernate.ddl-auto=create
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
### Build the Project
```
./mvnw clean install
```
### Run the Application
```
./mvnw spring-boot:run

```
### Access the Application
Once the application is running, you can access it at http://localhost:8080.
### Deploying the Application
```
./mvnw clean package
```
### Deploy the JAR File

```
java -jar target/task-app.jar
```
### Additional Information

- **Maven Wrapper:** The project uses Maven Wrapper, so you don't need to install Maven globally.
- **Java 17:** Ensure your system's JAVA_HOME is set to Java 17.