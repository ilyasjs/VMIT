package ejb;

import domain.StaffDomain;
import domain.StudentDomain;
import jpa.Person;
import jpa.Staff;
import jpa.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StaffServiceImpl implements StaffService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addStaff(StaffDomain staff) {
        Staff s = new Staff(staff.getFirstname(), staff.getLastname(), staff.getEmail(),
                staff.getPassword(), staff.getPhoneNumber(), staff.getDesignation());
        em.persist(s);
    }

    @Override
    public void updateStaff(StaffDomain staffDomain) {
        Staff s = em.find(Staff.class,staffDomain.getId());
        s.setFirstname(staffDomain.getFirstname());
        s.setLastname(staffDomain.getLastname());
        em.merge(s);
    }

    @Override
    public StaffDomain getStaff(Long id) {
        Staff staff = em.find(Staff.class, id);
        return new StaffDomain(staff.getId(), staff.getFirstname(), staff.getLastname(), staff.getEmail(), staff.getPassword(), staff.getPhoneNumber(), staff.getDesignation());
    }

    @Override
    public void removeStaff(Long id) {
        Staff student = em.find(Staff.class,id);
        em.remove(student);
    }
}
