package ejb;

import domain.*;
import jpa.Attendance;
import jpa.Course;
import jpa.Person;
import jpa.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class QueriesImpl implements Queries {

    private EntityManager em;

    @Override
    public List<StudentDomain> studentsEnrolledInCourse(CourseDomain course) {
        Query query = em.createNamedQuery("Course");
        query.setParameter("course", course);
        List<Course> courses = query.getResultList();
        List<StudentDomain> students = new ArrayList<>();
        if(courses != null) {
            Course requiredCourse = courses.get(0);
            List<Student> stu = requiredCourse.getStudents();
            for (Student student : stu) {
                students.add(new StudentDomain(student.getFirstname(), student.getLastname(), student.getEmail(),
                        student.getPhoneNumber()));
            }
        }
        return students;
    }

    @Override
    public List<AttendanceDomain> attendanceListForOneStudent(LoginDomain user) {
        Query query = em.createNamedQuery("getAttendanceForOneStudent");
        query.setParameter("studentId", user.getUserId());
        List<Attendance> attendances = query.getResultList();
        List<AttendanceDomain> attendanceDomains = new ArrayList<AttendanceDomain>();
        for (Attendance attendance :  attendances) {
            attendanceDomains.add(new AttendanceDomain(attendance.getAttendance(), attendance.getStudent(), attendance.getLesson()));
        }
        return attendanceDomains;
    }
}
