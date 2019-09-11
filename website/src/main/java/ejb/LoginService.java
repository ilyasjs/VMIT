package ejb;

import domain.LoginDomain;

import javax.ejb.Local;

/**
 * Created by Elev1 on 2018-01-18.
 */
@Local
public interface LoginService {
    LoginDomain submitLogin(String email, String password);
    //StudentDomain fetchUser(String email, String password);
}
