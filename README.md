# nisum-crud
Este proyecto tiene como finalidad presentar un ejercicio practico de un CRUD en spring boot

# estructura
src/
|-- main/
|   |-- java/
|   |   |-- com/
|   |       |-- nisum/
|   |           |-- crud/
|   |               |-- controller/
|   |               |   |-- UserController.java
|   |               |   |-- PhoneController.java
|   |               |
|   |               |-- model/
|   |               |   |-- User.java
|   |               |   |-- Phone.java
|   |               |
|   |               |-- repository/
|   |               |   |-- UserRepository.java
|   |               |   |-- PhoneRepository.java
|   |               |
|   |               |-- service/
|   |                   |-- UserService.java
|   |                   |-- PhoneService.java
|   |
|   |-- resources/
|       |-- application.properties
|
|-- test/
|   |-- java/
|   |   |-- com/
|   |       |-- nisum/
|   |           |-- crud/
|   |               |-- controller/
|   |               |   |-- UserControllerTest.java
|   |               |   |-- PhoneControllerTest.java
|   |               |
|   |               |-- service/
|   |                   |-- UserServiceTest.java
|   |                   |-- PhoneServiceTest.java
|
|-- pom.xml