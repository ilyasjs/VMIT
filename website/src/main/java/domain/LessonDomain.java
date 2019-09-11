package domain;

import jpa.Course;
import jpa.Student;

import java.util.Date;
import java.util.List;

public class LessonDomain {

    private Long id;
    private String lesson;
    private Date date;
    private CourseDomain course;
    private List<AttendanceDomain> attendances;

    public LessonDomain() {}

    public LessonDomain(String lesson, Date date, Course course) throws NullPointerException {
        this.lesson = lesson;
        this.date = date;
    }

    public List<AttendanceDomain> getAttendanceList() {
        return attendances;
    }

    public List<StudentDomain> getStudentList() {
        return course.getStudents();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getTopic() {
        return lesson;
    }

    public void setTopic(String topic) {
        this.lesson = topic;
    }

    public CourseDomain getCourse() {
        return course;
    }

    public void setCourse(CourseDomain course) {
        this.course = course;
    }

    public List<StudentDomain> getStudents() {
        return course.getStudents();
    }
}
