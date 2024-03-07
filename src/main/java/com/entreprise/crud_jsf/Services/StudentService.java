package com.entreprise.crud_jsf.Services;

import com.entreprise.crud_jsf.DAO.StudentImpl;
import com.entreprise.crud_jsf.Web.StudentModel;
import com.entreprise.crud_jsf.com.Entity.Student;
import jakarta.annotation.ManagedBean;

import java.util.List;

public class StudentService {
    private  StudentImpl student=new StudentImpl();
    private StudentModel studentModel;
    public boolean addStudent(Student s){
      return student.addStudent(s);
    }
    public List<Student> showStudent(){
        return student.showStudent();
    }
    public Student findStudent(long id){
        return student.findStudent(id);
    }
    public boolean updateStudent(long id,Student s){
        return student.updateData(id,s);
    }
    public void deleteStudent(long id){
        student.deleteStudent(id);
    }
}
