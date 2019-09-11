package jpa;

import javax.persistence.Entity;

@Entity
public class Staff extends Person {

    private String designation;

    public Staff(){}

    public Staff(Long id, String firstname, String lastname, String email, String password, String phoneNumber,
                 String designation) {
        super(id, firstname, lastname, email, password, phoneNumber);
        this.designation = designation;
    }

    public Staff(String firstname, String lastname, String email, String password, String phoneNumber,
                 String designation) {
        super(firstname, lastname, email, password, phoneNumber);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
