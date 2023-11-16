package com.dao;

import java.util.List;
import com.model.Student;

public interface StudentDetailsDAO {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean updateStudent(Student student);
    boolean addStudent(Student student);
    boolean deleteStudent(int id);
}
