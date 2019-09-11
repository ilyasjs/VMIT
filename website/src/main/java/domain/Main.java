package domain;

import domain.GeneratePassword;
import ejb.LoginServiceImpl;
import jpa.Attendance;
import jpa.Course;
import jpa.Lesson;
import jpa.Student;
import jsf.CourseBean;
import jsf.LoginBean;
import jsf.PersonBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    static EntityManager em;
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student Viji = new Student("Viji", "Lakhmi", "viji.somu10@gmail.com",
                "VuTFhYkHWI", "232323");
        Student Yamning = new Student ("Yamning", "Chen", "jdshff", "VuTFhYkHWI",
                "djkfhdkf");

        em.persist(Viji);
        em.persist(Yamning);

        Course physics = new Course("Physics");
        Course chemistry = new Course("Chemistry");

        em.persist(physics);
        em.persist(chemistry);

        physics.addStudent(Viji);
        physics.addStudent(Yamning);

        LoginServiceImpl loginService = new LoginServiceImpl(em);
        loginService.submitLogin("viji.somu10@gmail.com", "VuTFhYkHWI");

        CourseDomain courseDomain = new CourseDomain(physics.getCourseName());
        StudentDomain studentDomain = new StudentDomain(Viji.getFirstname(), Viji.getLastname(),
                Viji.getEmail(), Viji.getPhoneNumber());
        StudentDomain studentDomain2 = new StudentDomain(Yamning.getFirstname(), Yamning.getLastname(),
                Yamning.getEmail(), Yamning.getPhoneNumber());
        courseDomain.addStudent(studentDomain);
        courseDomain.addStudent(studentDomain2);
        CourseBean courseBean = new CourseBean(courseDomain.getCourseName());
        List<StudentDomain> listStudents = new ArrayList<StudentDomain>();
        courseBean.setStudents(courseDomain.getStudents());
        listStudents = courseBean.getStudents();

        for(StudentDomain student : listStudents) {
            System.out.println(student.getFirstname() + " " + student.getLastname());
            System.out.println(student.getEmail());
        }
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail("viji.somu10@gmail.com");
        loginBean.setPassword("VuTFhYkHWI");
        loginBean.submit();
        List<AttendanceDomain> att = loginBean.getAttendances();
        for (AttendanceDomain atten : att) {
            System.out.println(atten);
        }
        em.getTransaction().commit();

        em.close();



    }
}
