package com.entreprise.crud_jsf.Web;

import com.entreprise.crud_jsf.Services.StudentService;
import com.entreprise.crud_jsf.com.Entity.Student;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentModel implements Serializable {
    private static long id;
    private String name;
    private String email;
    private String departement;
    private String date;
    private List<Student> students;
     private boolean edite=false;
     private boolean add;
     private List<Student>studentsOne=new ArrayList<>();
    private List<Student>studentsTwo=new ArrayList<>();
    private List<Student>studentsNext=new ArrayList<>();
    private List<Student>studentsIndex=new ArrayList<>();

    public StudentModel(String name, String email, String departement, String date) {
        this.name = name;
        this.email = email;
        this.departement = departement;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public boolean isEdite() {
        return edite;
    }

    public void setEdite(boolean edite) {
        this.edite = edite;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }


    public void ToEdite(long studentID){
        StudentService studentService=new StudentService();
        Student s;
        s=studentService.findStudent(studentID);
        setId(studentID);
        setName(s.getName());
        setEmail(s.getEmail());
        setDepartement(s.getDepartement());
        setDate(s.getDate());
        edite=!edite;
        System.out.println(edite);

    }
    public void update(long studentId) throws IOException {
        StudentService studentService = new StudentService();
        Student updatedStudent = new Student(name, email, departement, date);
        boolean isUpdated = studentService.updateStudent(studentId, updatedStudent);
        students=studentService.showStudent();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.redirect("index.xhtml");
        edite = false;
    }
   public void ToAdd(){
        add=!add;
   }
   public void addStudent() {
       Student ns=new Student(name,email,departement,date);
       StudentService studentService=new StudentService();
       boolean isCreated=studentService.addStudent(ns);
       students=studentService.showStudent();
       name=" ";
       email=" ";
       departement=" ";
       date=" ";
       add=false;
   }
public void deleteStudent(long id){
    StudentService studentService=new StudentService();
    studentService.deleteStudent(id);
   students=studentService.showStudent();
    }
}


