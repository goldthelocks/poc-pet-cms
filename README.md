A simple PetCMS.

## Back end:
* Spring Boot
* Spring Data JPA
* Rest API

## Front end:
* AngularJS 1
* Bootstrap

## To run, execute the following:
1. cd poc-pet-cms
2. mvn clean install (if you prefer to skip tests, append this: -DskipTests)
3. cd poc-pet-cms/poc-pet-cms-app
4. mvn spring-boot:run

## To shutdown app:
curl -X POST localhost:8989/shutdown