package jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;
    private String lessonName;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="COURSE_ID")
    private Course course;

    private List<Student> students;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    public Lesson() {}

    public Lesson(String lesson, Date date, Course course) throws NullPointerException{
        this.lessonName = lesson;
        this.date = date;
        this.students = course.getStudents();
        if (this.students.isEmpty()) {
            throw new NullPointerException("There are no students enrolled in the course");
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getTopic() {
        return lessonName;
    }

    public void setTopic(String topic) {
        this.lessonName = topic;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }
}
