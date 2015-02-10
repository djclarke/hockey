package hockey.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Phone.PhoneId.class)
public class Phone {

    @Id
    private Person person;

    @Id
    private String type;

    private String phone;

    private boolean preferred = true;

    private boolean publish = false;

    public Phone() {

    }

    public Phone(Person person, String type, String phone) {
        super();
        this.person = person;
        this.type = type;
        this.phone = phone;
    }

    public Person getPerson() {
        return person;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public static class PhoneId implements Serializable {
        private static final long serialVersionUID = 1L;

        private long person;

        private String type;

        public PhoneId() {
        }

        public PhoneId(Phone phone) {
            this.person = phone.getPerson().getId();
            this.type = phone.getType();
        }
        
        public PhoneId(Person person, String type) {
            this.person = person.getId();
        }

        @Override
        public int hashCode() {
            return (int) (person + type.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj !=null && obj instanceof PhoneId) {
                PhoneId otherId = (PhoneId) obj;
                return this.person == otherId.getPerson() && this.type.equals(otherId.getType());
            }
            return false;
        }

        public long getPerson() {
            return person;
        }

        public void setPerson(long person) {
            this.person = person;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

}
