package hockey.model.persistence;

import hockey.model.Customer;

import java.io.File;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.oxm.MediaType;

public class Unmarshall {

    public static void main(String[] args) throws JAXBException {
        // JAXB Unmarshall
        Unmarshaller unmarshaller = PersistenceHelper.createUnmarshaller(MediaType.APPLICATION_JSON);
        
        File file = new File("target/customer.json");
        StreamSource source = new StreamSource(file);
        JAXBElement<Customer> jaxbElement = unmarshaller.unmarshal(source, Customer.class);

        Customer customer = jaxbElement.getValue();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
