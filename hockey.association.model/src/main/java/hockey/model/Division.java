package hockey.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Division {

    @Id
    private String name;

    public Division() {
        
    }
    
    public Division(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Division> defaultDivisions() {
        List<Division> divs = new ArrayList<Division>();
        divs.add(new Division("FUNdamentals"));
        divs.add(new Division("Novice"));
        divs.add(new Division("Atom"));
        divs.add(new Division("Peewee"));
        divs.add(new Division("Bantam"));
        divs.add(new Division("Midget"));
        divs.add(new Division("Intermediate"));
        return divs;
    }
}
