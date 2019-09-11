package ejb;

import domain.LoginDomain;
import domain.PersonDomain;
import jpa.Person;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elev1 on 2018-01-18.
 */
@Stateful
public class LoginServiceImpl implements LoginService {

    @PersistenceContext
    private EntityManager em;

    public LoginServiceImpl() {}

    public LoginServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public LoginDomain submitLogin(String email, String password) {
        Query query = em.createNamedQuery("PersonfindByEmailAndPassword");
        query.setParameter("email", email);
        query.setParameter("password", password);

//        List<Person> persons = query.getResultList();
        Person personFromDB = (Person) query.getSingleResult();
        System.out.println(personFromDB.toString());

        if (personFromDB == null) {
            return null;
        }

//        Person p = persons.get(0);
        PersonDomain personDomain = new PersonDomain(personFromDB.getId(), personFromDB.getFirstname(), personFromDB.getLastname(), personFromDB.getEmail(),
                personFromDB.getPhoneNumber());
        LoginDomain loginDomain = new LoginDomain(personDomain);
        return loginDomain;
    }

}