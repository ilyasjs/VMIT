package jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name="Course", query="SELECT c.lessons FROM Course c where c.courseName = :course")})
public class Course implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String courseName;
    @ManyToMany(mappedBy="courses")
    private List<Student> students;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    public Course() {

    }

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<Student>();
        this.lessons = new ArrayList<Lesson>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addLesson(Lesson lesson) {
        if(this.lessons == null) {
            this.lessons = new ArrayList<Lesson>();
            this.lessons.add(lesson);
        }
        this.lessons.add(lesson);
    }

    public List<Student> getStudents() throws NullPointerException {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if(this.students == null) {
            this.students = new ArrayList<Student>();
            this.students.add(student);
        }
        this.students.add(student);
    }
}