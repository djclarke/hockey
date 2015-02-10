package hockey.model.persistence;

import hockey.model.Category;
import hockey.model.Division;
import hockey.model.Season;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class InitDB {

    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("eclipselink.ddl-generation", "drop-and-create-tables");
        properties.put("eclipselink.ddl-generation.output-mode", "database");
        EntityManagerFactory emf = PersistenceHelper.createEMF(properties);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Division> divs = Division.defaultDivisions();

        for (Division div : divs) {
            em.persist(div);
        }

        Season season = new Season("2014/15", divs);
        Category noviceA = season.addCategory(divs.get(1), "A");
        noviceA.setCompetitive(true);
        em.persist(season);
        

        em.getTransaction().commit();
        em.close();

        emf.close();
    }

}
