package domain;

import java.util.ArrayList;
import java.util.List;

public class LoginDomain {

    private PersonDomain user;

    public LoginDomain() {
    }

    public LoginDomain(PersonDomain user) {
        this.user = user;
    }

    public PersonDomain getUser() {
        return user;
    }

    public Long getUserId() {
        return this.user.getId();
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public String getFirstname() {
        return this.user.getFirstname();
    }
}