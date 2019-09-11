package ejb;

import domain.*;

import java.util.List;

public interface Queries {

    List<StudentDomain> studentsEnrolledInCourse(CourseDomain course);
    List<AttendanceDomain> attendanceListForOneStudent(LoginDomain user);

}
