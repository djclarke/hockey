package hockey.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Email.EmailId.class)
public class Email {

    @Id
    private Person person;

    @Id
    private String type;

    private String email;

    private boolean preferred = true;

    private boolean publish = false;

    public Email() {

    }

    public Email(Person person, String type, String email) {
        super();
        this.person = person;
        this.type = type;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public static class EmailId implements Serializable {
        private static final long serialVersionUID = 1L;

        private long person;

        private String type;

        public EmailId() {
        }

        public EmailId(Email email) {
            this.person = email.getPerson().getId();
            this.type = email.getType();
        }
        
        public EmailId(Person person, String type) {
            this.person = person.getId();
        }

        @Override
        public int hashCode() {
            return (int) (person + type.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj !=null && obj instanceof EmailId) {
                EmailId otherId = (EmailId) obj;
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
