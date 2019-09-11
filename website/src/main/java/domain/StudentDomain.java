package domain;

import jpa.Course;
import jpa.Lesson;
import jpa.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentDomain implements Serializable{

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private List<CourseDomain> courses;

    public StudentDomain() {}

    public StudentDomain(Long id, String firstname, String lastname, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public StudentDomain(String firstname, String lastname, String email, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public List<CourseDomain> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDomain> courses) {
        this.courses = courses;
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