package com.systemStudents.students.service;

import com.systemStudents.students.model.Student;
import com.systemStudents.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> listStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public Student findById(int idStudent) {
        //devuelve null si no se encuentra el objeto
        Student student = studentRepository.findById(idStudent).orElse(null);
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
