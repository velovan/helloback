# HelloBackEnd


[![Build Status](https://travis-ci.org/velovan/helloback.svg?branch=master)](https://travis-ci.org/velovan/helloback)

Сервис - Spring Boot 1.4.1.  
SQL БД -  PostgreSQL 9.6.4-1.  
Сборка - Maven.  
Среда  - Eclipse IDE


Для работы приложения необходима БД helloBackEnd. Настройки доступа расположены в файле /resources/application.yml.
Таблица contacts имеет два поля
id - 64 bit integer
name - varchar


Для запуска приложения на локальном компьетере необходимо создать в PostgreSQL БД "helloBackEnd", скачать данный репозиторий, в файле /resources/application.yml изменить username и password для доступа к созданной локальной базе, подключить ваше IDE к БД "helloBackEnd", запустить Spring Boot 1.4.1.

Примеры запросов  
[http://localhost:8080/hello/contacts?nameFilter=^A.\*$&forward=true&lastId=0&limit=5](http://localhost:8080/hello/contacts?nameFilter=^A.\*$&forward=true&lastId=0&limit=5) - возвращает часть контактов, которые НЕ начинаются с A.  
[http://localhost:8080/hello/contacts?nameFilter=^.*[ai].*$&forward=true&lastId=0&limit=5](http://localhost:8080/hello/contacts?nameFilter=^.*[ai].*$&forward=true&lastId=0&limit=5) - возвращает часть контактов, которые НЕ содержат букв a, i.
