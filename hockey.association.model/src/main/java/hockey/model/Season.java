package hockey.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Season extends BaseEntity {

    private String name;
    
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="season")
    private List<Category> categories;

    protected Season() {
        this.categories = new ArrayList<Category>();
    }
    
    public Season(String name, List<Division> divisions) {
        this();
        this.name = name;
        
        for (Division div: divisions) {
            Category cat = new Category(div, this, div.getName().equals("FUNdamentals") ? "FUN" : "HL");
            this.categories.add(cat);
        }
    }

    public Season(String name, Season template) {
        this();
        this.name = name;
        // TODO: Use template to create categories
    }

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }
    
    public Category addCategory(Division div, String name) {
        Category cat = new Category(div, this, name);
        getCategories().add(cat);
        return cat;
    }

}
