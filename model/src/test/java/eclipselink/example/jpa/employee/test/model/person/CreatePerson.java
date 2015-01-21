/*******************************************************************************
 * Copyright (c) 2014  All rights reserved.
 ******************************************************************************/
package eclipselink.example.jpa.employee.test.model.person;

import hockey.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eclipselink.example.jpa.employee.test.PersistenceTesting;

public class CreatePerson {

    @Test
    public void create() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Person p1 = new Person();
        p1.setSurname("Doe");
        p1.setLastname("John");
        p1.setUserId("jdoe");
        p1.setDob(1970, 8, 13);
        
        em.persist(p1);
        
        Person p2 = new Person();
        p2.setSurname("Doe");
        p2.setLastname("Jane");
        p2.setUserId("jdoe");
        p2.setDob(1970, 8, 13);
        
        em.persist(p2);

        em.getTransaction().commit();
        em.close();
        
    }

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    @BeforeClass
    public static void createEMF() {
        emf = PersistenceTesting.createEMF(true);
    }

    @AfterClass
    public static void closeEMF() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        emf = null;
    }

}
