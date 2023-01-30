# City Management

## Summary

It takes the cities.csv that contains city names and photo urls as input and 
allow to list, filter, paginate and update.

## Installation

#### With Docker

Prerequisites:

* Docker version: 20.10.8
* Docker Compose version: 1.29.2
* Maven version: 3.5.4 

Steps:

* `cd backend`
* `mvn package`
* `cd ../`
* `docker-compose up`

It will be available in `http://localhost`

#### Without Docker

Prerequisites:

* Java version: openjdk 11.0.10 2021-01-19
* Maven version: 3.5.4 
* Spring CLI version: Spring CLI v2.7.8
* Angular version: 1.7.4

Steps:

* Run the backend application from your favorite IDE
* `cd frontend`
* `ng serve --open`

It will be available in `http://localhost:4200`

## Technical Details

### Capabilities

* List with pagination
* Filter by city name
* Update city name or photo url

### Backend Infrastructure

* Java version: openjdk 11.0.10 2021-01-19
* Maven version: 3.5.4 
* Spring CLI version: Spring CLI v2.7.8

### Frontend Infrastructure

* Angular version: 1.7.4

## Database Infrastructure

* In memory database

## More

Things can be improved:

* Unit tests can be written for frontend.
* Updating city information can be up to UserRole definitions.
* Endpoint information in the frontend can be moved to a config file.
* More persistent database system can be used.
* In city update screen, can be a drag drop photo upload component.