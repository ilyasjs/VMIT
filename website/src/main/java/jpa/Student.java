package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "StudentList", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "GetStudentByEmailAndPassword", query = "SELECT s FROM Student s WHERE s.email = :email AND " +
                "s.password = :password")
})
public class Student extends Person {

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="course_id", referencedColumnName="ID")
    )
    private List<Course> courses;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    public Student() {}

    public Student(Long id, String firstname, String lastname, String email, String password, String phoneNumber) {
        super(id, firstname, lastname, email, password, phoneNumber);
        this.courses = new ArrayList<Course>();
    }
    public Student(String firstname, String lastname, String email, String password, String phoneNumber) {
        super(firstname, lastname, email, password, phoneNumber);
        this.courses = new ArrayList<Course>();
    }

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
            courses.add(course);
        }
        courses.add(course);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public List getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;

    }

}
