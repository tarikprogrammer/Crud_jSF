package com.entreprise.crud_jsf.Services;

import com.entreprise.crud_jsf.DAO.StudentImpl;
import com.entreprise.crud_jsf.Web.StudentModel;
import com.entreprise.crud_jsf.com.Entity.Student;
import jakarta.annotation.ManagedBean;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private  StudentImpl student=new StudentImpl();
    private StudentModel studentModel;
    public boolean addStudent(Student s) {
        List<Student> studentList = new ArrayList<>();
        boolean status=true;
        studentList = student.showStudent();
        for (Student st : studentList) {
            if (((st.getEmail().trim()).equals(s.getEmail().trim()))) {
                status=false;
                break;
            }
        }
        if(status){
            student.addStudent(s);
        }
        return status;


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
    public long RowCount(){
        return student.getNumberOfRow();
    }
}
