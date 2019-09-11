package jsf;

import domain.*;
import ejb.LoginService;
import ejb.Queries;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Elev1 on 2018-01-18.
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private String email;
    private String password;
    private LoginDomain user;

    private static final String PERSISTENCE_UNIT_NAME = "Persistence-unit";
    @EJB
    LoginService loginService;
    @EJB
    Queries queries;

    public LoginBean(){}

    public String submit() {
        PersonDomain personDomain = new PersonDomain();
        this.user = new LoginDomain(personDomain);
        this.user = loginService.submitLogin(email, password);
        if(user != null) {
            return "index";
        }
        setPassword("");
        return "login";
    }

    public String getFirstName() {
        if(this.user == null) {
            return "Please login";
        }
        return this.user.getFirstname();
    }

    public List<AttendanceDomain> getAttendances() {
        return queries.attendanceListForOneStudent(user);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}