package jpa;


import javax.persistence.*;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "getAttendanceForOneStudent", query = "SELECT a FROM Attendance a where a.student = :studentId")
})
public class Attendance {

    @Id
    @GeneratedValue
    private Long id;
    private String attendance;
    @ManyToOne(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    private Student student;
    @ManyToOne(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    private Lesson lesson;

    public Attendance() {}

    public Attendance(String attendance, Student student, Lesson lesson) {
        this.attendance = attendance;
        this.student = student;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public String getAttendance() {
        return attendance;
    }

    public Student getStudent() {
        return student;
    }

    public void setAttendance(String attendance) {
        attendance = attendance;
    }

    public void markAttendance() {

    }
}
