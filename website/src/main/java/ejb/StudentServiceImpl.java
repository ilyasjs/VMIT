package ejb;

import domain.PersonDomain;
import domain.StudentDomain;
import jpa.Person;
import jpa.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addStudent(StudentDomain student) {
        Student s = new Student(student.getFirstname(), student.getLastname(), student.getEmail(),
                student.getPassword(), student.getPhoneNumber());
        em.persist(s);
    }

    @Override
    public void updateStudent(StudentDomain student) {
        Student s = em.find(Student.class,student.getId());
        s.setFirstname(student.getFirstname());
        s.setLastname(student.getLastname());
        em.merge(s);
    }

    @Override
    public StudentDomain getStudent(Long id) {
        Student student = em.find(Student.class, id);
        return new StudentDomain(student.getId(), student.getFirstname(), student.getLastname(), student.getEmail(), student.getPhoneNumber());
    }

    @Override
    public void removeStudent(Long id) {
        Student student = em.find(Student.class,id);
        em.remove(student);
    }
}
