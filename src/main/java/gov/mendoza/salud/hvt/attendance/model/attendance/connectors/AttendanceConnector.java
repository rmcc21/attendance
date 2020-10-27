package gov.mendoza.salud.hvt.attendance.model.attendance.connectors;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import gov.mendoza.salud.hvt.attendance.model.attendance.Attendance;

public interface AttendanceConnector {
    List<Attendance> get();
    Attendance getById(Long id);
    List<Attendance> getByUser(String username);
    List<Attendance> getByUserAndPeriod(String username, Date from, Date to);
    void save(Attendance attendance);    
    void delete(Long id);
}
