package com.entreprise.crud_jsf.DAO;

import com.entreprise.crud_jsf.com.Entity.*;


import jakarta.persistence.*;

import java.util.List;

public class StudentImpl implements Istudent{
    @Override
    public void addStudent(Student s) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa_student");
        EntityManager em= emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public List<Student> showStudent() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa_student");
        EntityManager em= emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Query query=em.createQuery("select e from Student e");
            List<Student>list=query.getResultList();
            em.getTransaction().commit();
            System.out.println("oui");
            return list;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("no");
            return null;
        }finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public Student findStudent(long id) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa_student");
        EntityManager em= emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Student s=em.find(Student.class,id);
            em.getTransaction().commit();
            return s;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            em.close();
            emf.close();
        }

    }

    @Override
    public boolean updateData(long id, Student data) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa_student");
        EntityManager em= emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Student s=em.find(Student.class,id);
            s.setName(data.getName());
            s.setEmail(data.getEmail());
            s.setDepartement(data.getDepartement());
            s.setDate(data.getDate());
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            em.close();
            emf.close();
        }

    }

    @Override
    public void deleteStudent(long id) {
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("jpa_student");
      EntityManager em=emf.createEntityManager();
      try{
          em.getTransaction().begin();
          Student s=em.find(Student.class,id);
          em.remove(s);
          em.getTransaction().commit();
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          em.close();
          emf.close();
      }
    }
}
