package com.example.hibernate.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BDUtils {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-hibernate-PU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void comenzarTransaccion(EntityManager em) {
        em.getTransaction().begin();
    }

    public static void commit(EntityManager em) {
        em.getTransaction().commit();
    }

    public static void close() {
        emf.close();
    }
}