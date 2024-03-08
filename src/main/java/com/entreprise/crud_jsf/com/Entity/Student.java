package com.entreprise.crud_jsf.com.Entity;


import jakarta.annotation.ManagedBean;
import jakarta.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@ManagedBean
@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String departement;
    private String date;

    public Student(String name, String email, String departement, String date) {
        this.name = name;
        this.email = email;
        this.departement = departement;
        this.date = date;
    }

    public Student() {
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

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
       return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
