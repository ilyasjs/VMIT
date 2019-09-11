package jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;

import domain.GeneratePassword;
import domain.PersonDomain;
import ejb.PersonService;

@ManagedBean
@RequestScoped
public class PersonBean {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
     //@Pattern(regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "invalid email")
    private String password;
    private String phoneNumber;
    @EJB
    private PersonService personService;

    public PersonBean() {

    }

    public PersonBean(Long id, String firstname, String lastname, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public PersonBean(String firstname, String lastname, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = getPassword();
    }


    public String addPerson() {
        if (getId() == null) {
            PersonDomain person = new PersonDomain(getFirstname(), getLastname(), getEmail(), getPhoneNumber());
            GeneratePassword pass = new GeneratePassword();
            person.setPassword(pass.password());
            personService.addPerson(person);
        }
        setId(null);
        setFirstname("");
        setLastname("");
        setEmail("");
        setPhoneNumber("");
        return "person";
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
