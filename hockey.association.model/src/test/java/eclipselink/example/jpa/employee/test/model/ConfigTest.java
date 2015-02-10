/*******************************************************************************
 * Copyright (c) 2014  All rights reserved.
 ******************************************************************************/
package eclipselink.example.jpa.employee.test.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import eclipselink.example.jpa.employee.test.PersistenceTesting;

public class ConfigTest {

    @Test
    public void bootstrap() {
        EntityManager em = getEmf().createEntityManager();

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
