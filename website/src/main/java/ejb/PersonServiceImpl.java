package ejb;

import domain.PersonDomain;
import jpa.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    private EntityManager em;


    public void addPerson(PersonDomain person) {
        Person p = new Person(person.getFirstname(), person.getLastname(), person.getEmail(), person.getPassword(),
                person.getPhoneNumber());
        em.persist(p);
    }

    public void updatePerson(PersonDomain person) {
        Person p = em.find(Person.class,person.getId());
        p.setFirstname(person.getFirstname());
        p.setLastname(person.getLastname());
        em.merge(p);

    }

    public PersonDomain getPerson(Long id) {
        Person p = em.find(Person.class,id);
        return new PersonDomain(p.getId(),p.getFirstname(),p.getLastname(), p.getEmail(), p.getPhoneNumber());
    }

    public void removePerson(Long id) {
        Person p = em.find(Person.class,id);
        em.remove(p);
    }

}
