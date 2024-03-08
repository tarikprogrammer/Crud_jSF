package com.entreprise.crud_jsf.DAO;

import com.entreprise.crud_jsf.com.Entity.Student;

import java.util.List;

public interface Istudent {
     void addStudent(Student s);
    List<Student> showStudent();
     Student findStudent(long id);
     boolean updateData(long id,Student s);

    void deleteStudent(long id);
}
