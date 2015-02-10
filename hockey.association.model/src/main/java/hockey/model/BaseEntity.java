package hockey.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version = 0l;

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }
}
