# search-craiglist
this project is to search type on craiglist site 

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

Prerequisites
1. Java 8 is installed.
2.Any Java IDE (preferably STS or IntelliJ IDEA).
3. Basic understanding of Java and Spring-based web development 

Built With
I have created application using Java 8 and SpringBoot. 
I have chosen SpringBoot because it is much easier to configure and plays well with other tech stacks. I have also used a REST API and ROME to read RSS feed.
I used Spring Initializer to add all the dependencies and create a blank working project with all my configurations.
I have used Maven as the build tool

To run this project:
You need some tool to test RestAPI. We can use postman to test this Restful API.
Once your application is up and running.
Use postman to send Get request to following URL:
 to See available type you can use to search on Craiglist: http://localhost:8082/api/v1/search
 based on type you can search as follows:
 for example to search an appartment: http://localhost:8082/api/v1/search/apartment
