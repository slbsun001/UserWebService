# UserWebService
A RESTful web service created using Maven in Eclipse. Simple project that implements CRUD operations.
I create a client server application,allows a user database to be created. A user registers with the following: firstname, lastname, email, mobile number and a PIN. The mobile number is used as a unique identifier, therefore if the mobile exists the user exists, any requests require the mobile number as input. These details are put into a MYSQL database.  

#Dev Environment
Eclipse- Java
Maven project

#Architectural style -REST. 
RESTful applications use HTTP requests to post data (create and/or update), read data (e.g., make queries), and delete data. Thus, REST uses HTTP for all four CRUD (Create/Read/Update/Delete) operations.
I make use of JAX-RS (a Java programming language API designed to make it easy to develop applications that use the REST architecture.)

Advanced Rest Client(Google App) is used to test and create the custom HTTP requests. 

#Server
jboss Wildfly server

#Database
The server-configuration folder contains the database configuration and user credentials(config.sql file). These can easily be modified. 
Database name : myproject
table: User
Columns: [pin, gender, date_of_birth, date_created, mobile, last_name, id, first_name, email, status]

The server will automatically connect to the database specified.

#To run the project
I run the project in eclipse. 
1. Run as Maven Build , with "clean verify" as build goals
2. Run on server- this will start the server and deploy
3. Open Google Chrome Browser-> Apps -> ARC(Advanced Rest Client)
4. Perform the various CRUD operations. The URL will be a local host port(Check the wildfly server properties)
    e.g Create
          url - http://localhost:8080/UserWebService/register
          Content-type - application/json
          Payload: the details corresponding to the columns
               { "firstName" :"Mickey",
                "lastName" :"Mouse",
                "emailAddress" :"mmouse@disney.com",
                "mobile":"0774383088",
                "dateOfBirth": "22 December 2005",
                "pinHash": "2582"}
