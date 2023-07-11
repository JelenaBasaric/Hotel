package domain;

import java.time.LocalDate;

/**
 *
 * @author Jelena Basaric
 */
public class Guest extends Person {
    private Person person;
    private int guestId;
    private String passportNo;
    private Registration registration;

    public Guest(int guestId, String passportNo, Registration registration, String firstName, String lastName, GenderEnum gender, String address, City city, String phoneNumber, String email, LocalDate dateOfBirth) {
        super(firstName, lastName, gender, address, city, phoneNumber, email, dateOfBirth);
        this.guestId = guestId;
        this.passportNo = passportNo;
        this.registration = registration;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

   

    public Guest(int guestId) {
        this.guestId = guestId;
    }

    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    @Override
    public String toString() {
        return guestId+", "+ this.getFirstName()+" "+this.getLastName()+ ", broj pasosa: " + passportNo  ;
    }

   
    

   
    

    
}
