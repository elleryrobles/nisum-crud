# Nisum-crud
Este proyecto que tiene como finalidad presentar un ejercicio practico de un CRUD en spring boot

## Instalación
Carga el proyecto en el IDE de preferencia, sugiero **Spring Tool Suite** ya que fue en este IDE que lo desarrollo, aunque es totalmente transparente el IDE que selecciones.

Luego de importar al IDE debes instalar las dependencias, puedes usar el IDE, para esto dar clic derecho al proyecto busca en el menú "Maven" y en el menú desplegable seleccionas "Update project" y en el cuadro de dialogo indicas el check "Force Update of Snapshots/Release" despues le das clic en "OK" y esperas a que se descargen las dependencias.

Despues de esto solo te diriges a la pestañas de servidores (Boot Dashboard)  y das clic en "Start".

## Pom.xml
En este archivo podras encontrar las dependiencias y versiones correspondientes para el desarrollo de la solución.

## Descripción
Consta de 2 entidades User y Phone en donde un usuario contiene muchos telefónos.

El objetivo es lograr un CRUD en donde la api pueda resolver la estructura de la cración de un usuario incluyendo alguinas validaciones como el correo no se repita tambien validar con una expresión regular el correo con esta apariencia "aaaaaa@dominio.cl"

En la respuesta se requiere una salida especifica en donde se logren apreciar algunos campo como:

- Id
- created
- modified
- active

En el repositorio encontraras una carpeta (docs) con los archivo de json correspondiente a Postman (Un cliente de consumo de Api)

## Base de datos
Esta es H2 es en memoria y para poder consultar se requiere:

- Url: http://localhost:8181/h2-ui/
- JDBC Url: jdbc:h2:mem:usuariosdb
- Usuario: admin
No tiene password

## Swagger
Para generar la documentación Api Rest de los servicios RESTful nos apoyamos en **Swagger** y con esta URL la podemos consultar:

- http://localhost:8181/swagger-ui/index.html

### Estructura de Usuario
- name
- email
- password
- phones []

### Estructura de Usuario
- number
- citycode
- contrycode

## Implementación
Esta solución consta de:

### Controller
- UserController.java
- PhoneController.java

### Model
- User.java
- Phone.java

### Repository
- UserRepository.java
- PhoneService.java

### Service
- UserService.java
- PhoneService.java

## Test
Un test donde se comprueba la creación de un usuario con el listado telefonos.

  
## estructura
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