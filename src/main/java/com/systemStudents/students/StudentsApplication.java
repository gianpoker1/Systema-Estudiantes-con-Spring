package com.systemStudents.students;

import com.systemStudents.students.model.Student;
import com.systemStudents.students.service.StudentService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	private static final Logger logger =
			LoggerFactory.getLogger(StudentsApplication.class);

	//salto de linea
	String nl= System.lineSeparator();

	public static void main(String[] args) {

		logger.info("Iniciando ...");
		SpringApplication.run(StudentsApplication.class, args);
		logger.info("Aplicacion finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "Ejecutando metodo RUN" + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}
	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				**** Sistema de Estudiantes ****
				 1. Listar Estudiantes
				 2. Buscar Estudiante
				 3. Agregar Estudiante
				 4. Modificar Estudiante
				 5. Eliminar Estudiante
				 6. Salir
				 Elige una opcion:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir= false;
		switch (opcion){
			case 1 ->{
				logger.info(nl + "Listado de estudiantes: " + nl);
				List<Student> students = studentService.listStudent();
				students.forEach((student-> logger.info(student.toString() + nl)));
			}
			case 2 ->{
				logger.info("Introduce id: ");
				var idStudent = Integer.parseInt(consola.nextLine());
				Student student = studentService.findById(idStudent);
				if(student != null){
					logger.info("Estudiante encontrado: " + student + nl);
				}else{
					logger.info("Estudiantes no encontrado (id): " + idStudent + nl);
				}
			}
			case 3 -> {
				logger.info("Añadir Estudiante:"+nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("Email: ");
				var email = consola.nextLine();
				Student student = new Student();
				student.setNombre(nombre);
				student.setApellido(apellido);
				student.setTelefono(telefono);
				student.setEmail(email );
				studentService.saveStudent(student);
				logger.info("Estudiante agregado: " + student + nl);
			}
			case 4 -> {
				logger.info("Modificar Estudiante: "+ nl);
				logger.info("Id Estudiante:");
				var idStudent = Integer.parseInt(consola.nextLine());
				//buscamos
				Student student = studentService.findById(idStudent);
				if(student != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					student.setNombre(nombre);
					student.setApellido(apellido);
					student.setTelefono(telefono);
					student.setEmail(email );
					studentService.saveStudent(student);
					logger.info("Estudiante actualizado: " + student + nl);
				}else{
					logger.info("Estudiante no encontrado con id: " + idStudent +nl);
				}
			}
			case 5 ->{
				logger.info("Eliminar Estudiante" +nl);
				logger.info("Id de estudiante a eliminar: ");
				var id = Integer.parseInt(consola.nextLine());
				//buscamos
				Student student = studentService.findById(id);
				if(student != null){
					studentService.deleteStudent(student);
					logger.info("Estudiante eliminado: " + student+nl);
				}else{
					logger.info("Id de Estudiante no encontrado: " + id);
				}
			}
			case 6 -> {
				logger.info("Hasta pronto."+nl+nl);
				salir = true;
			}
			default -> logger.info("Opcion no reconocida."+nl);
		}
		return salir;
	}
}
