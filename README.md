# Sistema de Gestión de Estudiantes

Este proyecto es una aplicación de consola desarrollada en Java utilizando Spring Boot, que permite gestionar estudiantes en una base de datos MySQL. La aplicación ofrece funcionalidades CRUD (Crear, Leer, Actualizar, Eliminar) para los estudiantes.

## Características

- **Listar Estudiantes**: Muestra una lista de todos los estudiantes en la base de datos.
- **Buscar Estudiante**: Permite buscar un estudiante por su ID.
- **Agregar Estudiante**: Permite agregar un nuevo estudiante a la base de datos.
- **Modificar Estudiante**: Permite actualizar la información de un estudiante existente.
- **Eliminar Estudiante**: Permite eliminar un estudiante de la base de datos.

## Tecnologías Utilizadas

- **Spring Boot**: Para la creación de la aplicación.
- **Spring Data JPA**: Para la interacción con la base de datos.
- **MySQL**: Como sistema de gestión de base de datos.
- **Lombok**: Para simplificar el modelo de datos.

## Instrucciones de Uso

1. Clona el repositorio.
2. Configura la base de datos MySQL con las credenciales proporcionadas en `application.properties`.
3. Ejecuta la aplicación utilizando `mvn spring-boot:run`.
4. Sigue las instrucciones en la consola para gestionar los estudiantes.


## Instrucciones de Instalación:

### Clonar el Repositorio:
git clone https://github.com/gianpoker1/Systema-Estudiantes-con-Spring.git

cd Systema-Estudiantes-con-Spring

### Configurar la Base de Datos MySQL:

Asegúrate de tener MySQL instalado y en funcionamiento.

Crea una base de datos llamada students_db.

Configura las credenciales de la base de datos en el archivo **src/main/resources/application.properties:**

`spring.datasource.url=jdbc:mysql://localhost:3306/students_db`

spring.datasource.username=your_user

spring.datasource.password=yourpassword

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`

### Ejecutar la Aplicación:
Asegúrate de tener Maven instalado.
Ejecuta la aplicación utilizando el siguiente comando:

mvn spring-boot:run

## Estructura del Proyecto
- **com.systemStudents.students:**

***StudentsApplication.java:*** Clase principal que implementa CommandLineRunner para ejecutar el menú de consola.
  
- **com.systemStudents.students.model:**

**Student.java:** Clase de entidad que representa a un estudiante. Utiliza Lombok para simplificar el código.

- **com.systemStudents.students.repository:**

**StudentRepository.java:** Interfaz que extiende JpaRepository para realizar operaciones CRUD en la base de datos.

- **com.systemStudents.students.service:**

**IStudentService.java:** Interfaz que define los métodos del servicio de estudiantes.

**StudentService.java:** Implementación de IStudentService que utiliza StudentRepository para interactuar con la base de datos.

## Uso de la Aplicación
Una vez que la aplicación esté en funcionamiento, se mostrará un menú en la consola con las siguientes opciones:

1. **Listar Estudiantes:** Muestra una lista de todos los estudiantes en la base de datos.
2. **Buscar Estudiante:** Permite buscar un estudiante por su ID.
3. **Agregar Estudiante:** Permite agregar un nuevo estudiante a la base de datos.
4. **Modificar Estudiante:** Permite actualizar la información de un estudiante existente.
5. **Eliminar Estudiante:** Permite eliminar un estudiante de la base de datos.
6. **Salir:** Cierra la aplicación.


## Dependencias
El proyecto utiliza las siguientes dependencias principales:

- **Spring Boot:** Framework para desarrollar aplicaciones Java.

- **Spring Data JPA:** Para la interacción con la base de datos.

- **MySQL:** Sistema de gestión de base de datos.

- **Lombok:** Para simplificar el modelo de datos.
