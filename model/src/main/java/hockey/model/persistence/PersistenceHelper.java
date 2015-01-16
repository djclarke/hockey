package hockey.model.persistence;

import static org.eclipse.persistence.jaxb.JAXBContextProperties.JSON_INCLUDE_ROOT;
import static org.eclipse.persistence.jaxb.JAXBContextProperties.JSON_WRAPPER_AS_ARRAY_NAME;
import static org.eclipse.persistence.jaxb.JAXBContextProperties.MEDIA_TYPE;
import hockey.model.Customer;

import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.oxm.MediaType;

public class PersistenceHelper {

    private static final String PU_NAME = "hockey";

    public static EntityManagerFactory createEMF(Map<String, ?> props) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU_NAME, props);

        return emf;
    }

    public static Marshaller createMarshaller(MediaType mediaType) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
        marshaller.setProperty(MEDIA_TYPE, mediaType.getMediaType());
        marshaller.setProperty(JSON_INCLUDE_ROOT, false);
        marshaller.setProperty(JSON_WRAPPER_AS_ARRAY_NAME, true);
        
        return marshaller;
    }

    public static Unmarshaller createUnmarshaller(MediaType mediaType) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setProperty(MEDIA_TYPE, mediaType.getMediaType());
        unmarshaller.setProperty(JSON_INCLUDE_ROOT, false);
        unmarshaller.setProperty(JSON_WRAPPER_AS_ARRAY_NAME, true);
        
        return unmarshaller;
    }
}
