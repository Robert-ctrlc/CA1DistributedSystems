package com.example.dit;

import com.example.dit.model.Student;
import com.example.dit.model.Deposit;
import com.example.dit.model.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import java.util.List;

public class StudentDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb");

    public void saveStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Student findStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Student.class, id);
        } finally {
            em.close();
        }
    }

    public void updateStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Student> getAllStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Loan findLoan(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Loan loan = em.find(Loan.class, id);
            
            if (loan != null) {
                loan.getDeposits().size(); 
            }
            return loan;
        } finally {
            em.close();
        }
    }

    public void saveLoan(Loan loan) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(loan);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void saveDeposit(Deposit deposit) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(deposit);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void updateLoan(Loan loan) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(loan);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

