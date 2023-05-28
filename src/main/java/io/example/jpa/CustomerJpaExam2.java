package io.example.jpa;

import io.example.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        //
        try {
            Customer customer = new Customer("ID0001", "Kim");
//            em.persist(customer); // insert X

            Customer cus01 = em.find(Customer.class, "ID0001");
            System.out.println(cus01.toString());

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
