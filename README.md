# Spring_test-postgres-hibernate

### How to start application 

- Start Postgres SQL server on the PC
- Run application:  **mvn compile spring-boot:run**
- Run tests:  **mvn test**


### Implementation mortgage application
##### 1. Install and run Postgree SQL server on the PC

1.1 Go to Postgree server admin tool 'pgAdmin' and create database 'postgres-hibernate-demo'

1.2 rem: Other database name, user name and password can be configured in file:

_'src/main/resources/application.properties'_

##### 2. Initialyze Spring app througth start.spring.io

Maven prroject with 8 java

	add dependency
  
		- Spring Boot DevTools
		- Spring Web
		- Sprind data JPA
    
  2.2 Open project and add to maven postgres JDBC driver
  
##### 3.  Created database Entity: MortgageApplication (@Entity@Table)
  
##### 4. Creted Model entitities: MorgageRequest/MorgageResponce /MortgageList  (should be serializable for database)
  
##### 5. Created Controller class with mapping endpoins (@RestController)
   _http://localhost:8080/mortgages_
   
##### 6. Created two type of repository: manual and extended from JpaRepository
  
##### 7. Create some simple services 
