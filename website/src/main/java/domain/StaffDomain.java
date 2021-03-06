package domain;

import java.util.ArrayList;
import java.util.List;

public class StaffDomain {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String designation;

    public StaffDomain() {}

    public StaffDomain(Long id, String firstname, String lastname, String email, String password, String phoneNumber,
                 String designation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
    }

    public StaffDomain(String firstname, String lastname, String email, String phoneNumber, String designation) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
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