package hockey.model.persistence;

import hockey.model.Customer;

import java.awt.Desktop;
import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.oxm.MediaType;

public class Marshall {

    public static void main(String[] args) throws JAXBException {
        // JPA Query
        EntityManagerFactory emf = PersistenceHelper.createEMF(null);
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, 1l);
        em.close();
        emf.close();

        // JAXB Marshall
        Marshaller marshaller = PersistenceHelper.createMarshaller(MediaType.APPLICATION_JSON);
        
        File file = new File("target/customer.json");
        marshaller.marshal(customer, file);

        launchSystemBrowser(file);

    }

    public static void launchSystemBrowser(File file) {
        try {
            Desktop.getDesktop().browse(file.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
