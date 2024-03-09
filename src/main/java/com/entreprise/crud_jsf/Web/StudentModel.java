package com.entreprise.crud_jsf.Web;

import com.entreprise.crud_jsf.Services.StudentService;
import com.entreprise.crud_jsf.com.Entity.Student;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

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
    private String message;
    private List<Student> currentPageData;
    private int currentPageIndex = 0;
    private int pageSize = 4;


    public StudentModel(String name, String email, String departement, String date) {
        this.name = name;
        this.email = email;
        this.departement = departement;
        this.date = date;
    }
    public StudentModel() {
        StudentService studentService =new StudentService();
        students=studentService.showStudent();
        loadCurrentPageData();

    }
    private void loadCurrentPageData() {
        currentPageData = new ArrayList<>();
        int startIndex = currentPageIndex * pageSize;
        int endIndex = Math.min(startIndex + pageSize, students.size());
        for (int i = startIndex; i < endIndex; i++) {
            currentPageData.add(students.get(i));
        }
    }
    public void nextPage() {
        if (currentPageIndex < getTotalPages() - 1) {
            currentPageIndex++;
            loadCurrentPageData();
        }
    }
    public void previousPage() {
        if (currentPageIndex > 0) {
            currentPageIndex--;
            loadCurrentPageData();
        }
    }
    public List<Student> getCurrentPageData() {
        return currentPageData;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) students.size() / pageSize);
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
    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
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

    }
    public void update(long studentId) throws IOException {
        StudentService studentService = new StudentService();
        Student updatedStudent = new Student(name, email, departement, date);
        boolean isUpdated = studentService.updateStudent(studentId, updatedStudent);
        if(isUpdated){
            setMessage("Row has been updated successfuly");
        }
        setStudents(studentService.showStudent());
        currentPageData=studentService.showStudent();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.redirect("index.xhtml");
        edite = false;
    }
   public void ToAdd(){
        add=!add;
   }
   public void addStudent() throws IOException {
        if(!(name.equals("") || email.equals("") || departement.equals("") || date.equals(""))){
            Student ns=new Student(name,email,departement,date);
            StudentService studentService=new StudentService();
            boolean isCreated=studentService.addStudent(ns);
            if(isCreated){
                setMessage("Row has been added successfuly");
            }else{
                setMessage("Email exist .... or something is wrong please try again !!!!");
            }
            setStudents(studentService.showStudent());
            currentPageData=studentService.showStudent();
            name=" ";
            email=" ";
            departement=" ";
            date=" ";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.redirect("index.xhtml");
            add=false;
        }else{
            setMessage("Email exist .... or something is wrong please try again !!!!");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.redirect("index.xhtml");
            add=false;
        }

   }
public void deleteStudent(long id){
    StudentService studentService=new StudentService();
    studentService.deleteStudent(id);
    setMessage("Row has been deleted successfuly");
    setStudents(studentService.showStudent());
    currentPageData=studentService.showStudent();
    }



}


