package hockey.model.team;

import hockey.model.BaseEntity;
import hockey.model.Category;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Team extends BaseEntity{

    @ManyToOne(fetch=FetchType.LAZY)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}