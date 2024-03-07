package com.entreprise.crud_jsf.DAO;

import com.entreprise.crud_jsf.Services.StudentService;
import com.entreprise.crud_jsf.com.Entity.Student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataBase {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("tarik belaid");
        student.setEmail("tarikbelaid@gmail.com");
        student.setDepartement("Gi");
        Date date = new Date(2023 - 1900, 11, 5);
        SimpleDateFormat fs=new SimpleDateFormat("yyyy-MM-dd");
        student.setDate(new Date(2023-1900,11,5));
        StudentService studentService=new StudentService();
        boolean isCreate=studentService.addStudent(student);
        System.out.println(isCreate);
        List<Student> list=new ArrayList<>();
        list=studentService.showStudent();
        for(Student test:list){
            System.out.println(test.getName()+" "+test.getEmail()+" "+test.getDepartement()+" "+test.getDate());
        }

    }
}
