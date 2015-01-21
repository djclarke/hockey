package hockey.model;

import hockey.model.team.Team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Category extends BaseEntity {

    private String name;
    
    private Division division;
    
    private Season season;
    
    @OneToMany(mappedBy="category")
    private List<Team> teams;
    
    private boolean competitive = false;
    
    private Person convenor;

    protected Category() {
        this.teams = new ArrayList<Team>();
    }
    
    protected Category(Division division, Season season, String name) {
        this();
        this.division = division;
        this.season = season;
        this.name = name;
    }

    protected Category(Division division, Season season, String name, boolean competitive) {
        this(division, season, name);
        this.competitive = competitive;
    }

    public String getName() {
        return name;
    }

    public Division getDivision() {
        return division;
    }

    public Season getSeason() {
        return season;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Person getConvenor() {
        return convenor;
    }

    public void setConvenor(Person convenor) {
        this.convenor = convenor;
    }

    public boolean isCompetitive() {
        return competitive;
    }

    public void setCompetitive(boolean competitive) {
        this.competitive = competitive;
    }

}
