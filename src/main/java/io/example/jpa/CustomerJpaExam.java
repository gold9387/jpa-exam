package io.example.jpa;

import io.example.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        //
        try {
//            em.persist(Customer.sample()); // insert
            Customer foundCustomer = em.find(Customer.class, "ID0001"); // select
//            foundCustomer.setName("Park"); // update
            em.remove(foundCustomer); // delete

            System.out.println(foundCustomer.toString());
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
