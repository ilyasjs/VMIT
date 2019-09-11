
package jsf;
import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.GeneratePassword;
import domain.StudentDomain;
import ejb.Queries;
import ejb.StudentService;
import jpa.Course;
import jpa.Lesson;
import jpa.Student;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class StudentBean {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private List<CourseDomain> courses;
    private List<AttendanceDomain> attendances;
    @EJB
    private StudentService studentService;
    @EJB
    private Queries queries;

    public StudentBean() {

    }

    public StudentBean(Long id, String firstname, String lastname, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public StudentBean(String firstname, String lastname, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = getPassword();
    }


    public void emptyForm() {
        setId(null);
        setFirstname("");
        setLastname("");
        setEmail("");
        setPhoneNumber("");
    }

    public String addStudent() {
        if (getId() == null) {
            StudentDomain student = new StudentDomain(getFirstname(), getLastname(), getEmail(), getPhoneNumber());
            GeneratePassword pass = new GeneratePassword();
            student.setPassword(pass.password());
            studentService.addStudent(student);
        }
        emptyForm();
        return "person";
    }

    public void setCourses(List<CourseDomain> courses) {
        this.courses = courses;
    }

    public List<CourseDomain> getCourses() {
        return courses;
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
