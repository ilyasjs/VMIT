package jsf;

import domain.CourseDomain;
import domain.LessonDomain;
import domain.StudentDomain;
import ejb.Queries;
import jpa.Course;
import jpa.Lesson;
import jpa.Student;

import javax.ejb.EJB;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CourseBean {


    private Long id;
    private String courseName;
    private List<StudentDomain> students;
    private List<LessonDomain> lessons;
    @EJB
    private Queries queries;

    public CourseBean() {}

    public CourseBean(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<StudentDomain>();
        this.lessons = new ArrayList<LessonDomain>();
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

    public void addLesson(LessonDomain lesson) {
        if(this.lessons == null) {
            this.lessons = new ArrayList<LessonDomain>();
            this.lessons.add(lesson);
        }
        this.lessons.add(lesson);
    }

    public List<StudentDomain> StudentsEnrolledInCourse(CourseDomain course) {
        return queries.studentsEnrolledInCourse(course);
    }

    public List<StudentDomain> getStudents() throws NullPointerException {
        return students;
    }

    public void setStudents(List<StudentDomain> students) {
        this.students = students;
    }

    public void addStudent(StudentDomain student) {
        if(this.students == null) {
            this.students = new ArrayList<StudentDomain>();
            this.students.add(student);
        }
        this.students.add(student);
    }
}
