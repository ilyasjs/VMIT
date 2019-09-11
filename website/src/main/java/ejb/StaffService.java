package ejb;

import domain.StaffDomain;
import domain.StudentDomain;

public interface StaffService {
    void addStaff(StaffDomain staff);
    void updateStaff(StaffDomain staff);
    StaffDomain getStaff(Long id);
    void removeStaff(Long id);
}
