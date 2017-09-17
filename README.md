# HelloBackEnd

helloback was designed to provide a way to access data from the client application through RESTful API.

[![Build Status](https://travis-ci.org/velovan/helloback.svg?branch=master)](https://travis-ci.org/velovan/helloback)

Project uses the following technologies:

 
• Spring Boot 1.4.1.  
• PostgreSQL 9.6.4-1.  
• Maven.  
• Eclipse IDE

Create database helloBackEnd. Change password/username in application.yml file.
The table has two fields:
id - 64 bit integer
name - varchar



Примеры запросов  
[http://localhost:8080/hello/contacts?nameFilter=^A.\*$&forward=true&lastId=0&limit=5](http://localhost:8080/hello/contacts?nameFilter=^A.\*$&forward=true&lastId=0&limit=5) - возвращает часть контактов, которые НЕ начинаются с A.  
[http://localhost:8080/hello/contacts?nameFilter=^.*[ai].*$&forward=true&lastId=0&limit=5](http://localhost:8080/hello/contacts?nameFilter=^.*[ai].*$&forward=true&lastId=0&limit=5) - возвращает часть контактов, которые НЕ содержат букв a, i.
