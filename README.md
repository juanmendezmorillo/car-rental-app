# Car-Rental-App

Application for managing the rental administration with three primaries functions:

- Have an inventory of cars.
- Calculate the price for rental.
- Keep the track of the customer loyalty points.

# Build guide

## Maven

### Testing

Verify that you can compile and pass the tests:

```
mvn clean test
```

For test report and code coverage:

```
mvn surefire-report:report
open target/site/surefire-report.html

mvn jacoco:report
open target/site/jacoco/index.html
```

### <a id="start" />Start

Run the back-end API locally:

```
mvn spring-boot:run
```

Another way is to build it as a '.jar' and run it:

```
mvn clean install 
java -jar .\target\carrentapp-0.0.1-SNAPSHOT.jar
```

# Server check

To access the database (H2) in dev mode:

```
open http://localhost:8080/h2-console 
```

API Documentation (Swagger):

```
open http://localhost:8080/v3/api-docs
open http://localhost:8080/swagger-ui.html
```

# Development Steps

* I have used a 'hex architecture' of 'ports' (interfaces) and 'adapters' (implementations)
  with the motivation of separating the application into different layers, each one with its own responsibility
  and allowing you to evolve in an isolated way.

  Initially I have focused on the 'domain' layer where I have created the necessary classes and methods to
  provide a solution to the functional requirements (business) of the 'Car rental system' program. 
  Next I have created the output 'ports' and 'adapters' (database) for data persistence. 
  Finally I created the input 'ports' and 'adapters' (rest api) in order to expose the available system operations.

  Some important aspects have remained to be carried out, such as user authentication and authorization,
  overlaps in reservation dates for the same car, increased test coverage, crud users, crud car.

* The creation of 'tables' and loading of 'data' is done in the file 'V1_create_tables_and_insert_data.sql' 
  at startup the application [Start](#start).

* The version of 'spring-boot' used is '2.7.8' with java '1.8', the database has been used
  'h2' (runs in memory) 'flyway' to load the schema in 'h2', 'jpa' for operations with the
  database, 'lombok', 'modelmapper', 'openapi', 'jacoco'.

#### Thank you for your time.

