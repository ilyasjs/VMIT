package ejb;

import domain.PersonDomain;

import javax.ejb.Local;

@Local
public interface PersonService {

    void addPerson(PersonDomain person);
    void updatePerson(PersonDomain person);
    PersonDomain getPerson(Long id);
    void removePerson(Long id);
}
