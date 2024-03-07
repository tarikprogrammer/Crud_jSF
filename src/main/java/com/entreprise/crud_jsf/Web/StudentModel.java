package com.entreprise.crud_jsf.Web;

import com.entreprise.crud_jsf.Services.StudentService;
import com.entreprise.crud_jsf.com.Entity.Student;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentModel implements Serializable {
    private long id;
    private String name;
    private String email;
    private String departement;
    private Date date;
    private List<Student> students;
    private boolean edite;
    private boolean tsetAdd;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message = "";

    public StudentModel(String name, String email, String departement, Date date,boolean edite) {
        this.name = name;
        this.email = email;
        this.departement = departement;
        this.date = date;
        this.edite=edite;
    }
    public StudentModel() {
        StudentService studentService =new StudentService();
        students=studentService.showStudent();

    }
    //setters and getters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean isEdite() {
        return edite;
    }

    public void setEdite(boolean edite) {
        this.edite = edite;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isTsetAdd() {
        return tsetAdd;
    }

    public void setTsetAdd(boolean tsetAdd) {
        this.tsetAdd = tsetAdd;
    }

    public void toggleEdite(long id) {
        StudentService studentService=new StudentService();
        Student s=new Student();
        s=studentService.findStudent(id);
        setId(id);
        setName(s.getName());
        setEmail(s.getEmail());
        setDepartement(s.getDepartement());
        setDate(s.getDate());
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getEmail());
        System.out.println(s.getDate());
        edite=!edite;
        this.id=id;

    }
    public void update(long id){
        Student s=new Student(name,email,departement,date);
        System.out.println(id);
        System.out.println(name);
        System.out.println(email);
        System.out.println(departement);
        System.out.println(date);
        StudentService studentService=new StudentService();
        //boolean isUpdated =studentService.updateStudent(id,s);
        edite=false;
        this.id=id;

    }
  public void toggleAdd(){
        tsetAdd=!tsetAdd;

  }
  public void save(){
        Student ns=new Student(name,email,departement,date);
        StudentService studentService=new StudentService();
        boolean isCreated=studentService.addStudent(ns);
        students.add(ns);
        students=studentService.showStudent();
        tsetAdd=false;

  }
  public void delete(long id){
      System.out.println(id);
      StudentService studentService=new StudentService();
      studentService.deleteStudent(id);
      students=studentService.showStudent();

  }


}
