package hockey.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Index;

@Entity
public class Person extends BaseEntity {

    @Index(unique=true)
    private String userId;
    
    private String surname;
    
    private String lastname;
    
    @Temporal(TemporalType.DATE)
    private Calendar dob;
    
    @OneToMany(mappedBy="person")
    private List<Email> emails = new ArrayList<Email>();

    @OneToMany(mappedBy="person")
    private List<Phone> phones = new ArrayList<Phone>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(int year, int month, int day) {
        this.dob = Calendar.getInstance();
        this.dob.set(year, month, day);
    }

    public List<Email> getEmails() {
        return emails;
    }
    
}
