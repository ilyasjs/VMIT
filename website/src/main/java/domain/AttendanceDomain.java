package domain;

import jpa.Lesson;
import jpa.Student;


public class AttendanceDomain {

    private Long id;
    private String attendance;
    private Student student;
    private Lesson lesson;

    public AttendanceDomain() {}

    public AttendanceDomain(String attendance, Student student, Lesson lesson) {
        this.attendance = attendance;
        this.student = student;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public String getAttendance() {
        return attendance;
    }

    public Student getStudent() {
        return student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setAttendance(String attendance) {
        attendance = attendance;
    }

    @Override
    public String toString() {
        return attendance + " " + student.getLastname() + " " + lesson;
    }

    public void markAttendance() {

    }
}
