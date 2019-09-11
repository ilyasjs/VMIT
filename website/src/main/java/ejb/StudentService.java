package ejb;

import domain.PersonDomain;
import domain.StudentDomain;
import jpa.Student;

public interface StudentService {

    void addStudent(StudentDomain student);
    void updateStudent(StudentDomain student);
    StudentDomain getStudent(Long id);
    void removeStudent(Long id);
}
