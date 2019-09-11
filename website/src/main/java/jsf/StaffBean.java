package jsf;

import domain.CourseDomain;
import domain.GeneratePassword;
import domain.StaffDomain;
import domain.StudentDomain;
import ejb.StaffService;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class StaffBean {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String designation;
    @EJB
    StaffService staffService;

    public StaffBean() {}

    public StaffBean(Long id, String firstname, String lastname, String email, String password, String phoneNumber,
                       String designation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
    }

    public StaffBean(String firstname, String lastname, String email, String phoneNumber, String designation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
    }

    public void emptyForm() {
        setId(null);
        setFirstname("");
        setLastname("");
        setEmail("");
        setPhoneNumber("");
    }

    public String addStaff() {
        if (getId() == null) {
            StaffDomain staff = new StaffDomain(getFirstname(), getLastname(), getEmail(), getPhoneNumber(), getDesignation());
            GeneratePassword pass = new GeneratePassword();
            staff.setPassword(pass.password());
            staffService.addStaff(staff);
        }
        emptyForm();
        return "person";
    }

    public List<StudentDomain> StudentsEnrolledInCourse(List<StudentDomain> students, CourseDomain course) {
        List<StudentDomain> studentsInCourse = new ArrayList<StudentDomain>();
        for (StudentDomain student : students) {
            if (student.getCourses().contains(course)) {
                studentsInCourse.add(student);
            }
        }
        return studentsInCourse;
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

    public String getPhoneNumber() { return phoneNumber; }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
