# Undercooked

This learning project aimed to develop a website allowing users to search for recipes based on available ingredients. It was a collaborative effort where we utilized Java Spring Boot for the backend, PostgreSQL for data storage, and JavaScript+React for the frontend. 

## Frontend

<a href="https://github.com/BathoBence/undercooked_frontend" target="blank"> You can find the frontend here. </a>


## Technologies

* <a href="https://www.java.com/en/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/java.svg" height="25" /> Java </a>
* <a href="https://spring.io/projects/spring-boot" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/spring.svg" height="25" /> Spring Boot </a>
* <a href="https://www.postgresql.org/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/postgresql.svg" height="25" /> PostgreSQL </a>

## Setup 
***- Before you begin, ensure you have met the following requirements:***

- Java Development Kit (JDK) installed (version 17.0.8)

- Maven build tool installed (version 3.9.2)

- SQL database (e.g., MySQL, PostgreSQL) installed and running

- IDE (e.g., IntelliJ IDEA, Eclipse) installed for development (optional but recommended)

**Steps**

***- Clone the Repository***
```
git clone git@github.com:BathoBence/UnderCooked.git
```

***- Set Up the Database***

Create a new database instance in your SQL database.

Configure the database connection details using environment variables in application.properties file located in src/main/resources/ directory.

Use the seed_db file to populate the database.

***- Build the Application***
```
mvn clean install
```
***- Run the Application***
```
java -jar target/backend-<version>.jar
```
Replace <version> with the version of your application.
