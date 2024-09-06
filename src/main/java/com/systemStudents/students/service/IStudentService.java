package com.systemStudents.students.service;

import com.systemStudents.students.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {
    public List<Student> listStudent();

    public Student findById(int idStudent);

    public void saveStudent(Student student);

    public void deleteStudent(Student student);
}
