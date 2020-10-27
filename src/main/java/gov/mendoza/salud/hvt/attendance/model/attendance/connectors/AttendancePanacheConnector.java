package gov.mendoza.salud.hvt.attendance.model.attendance.connectors;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

import gov.mendoza.salud.hvt.attendance.model.attendance.Attendance;
import gov.mendoza.salud.hvt.attendance.model.attendance.jpa.AttendanceJPA;
import gov.mendoza.salud.hvt.attendance.model.attendance.repositories.AttendanceRepostiry;

@ApplicationScoped
public class AttendancePanacheConnector implements AttendanceConnector {
    @Inject AttendanceRepostiry attendanceRepostiry;
    
    ModelMapper modelMapper;
    public AttendancePanacheConnector() {
        modelMapper = new ModelMapper();   
        modelMapper.getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(AccessLevel.PUBLIC);     
    }

    @Override
    public List<Attendance> get() {
        return listToModel(attendanceRepostiry.listAll());
    }

    @Override
    public Attendance getById(Long id) {
        return attendanceJPAtoAttendance(attendanceRepostiry.findById(id));        
    }

    @Override
    public List<Attendance> getByUser(String username) {
        return listToModel(attendanceRepostiry.getByUsername(username));
    }

    @Override
    public List<Attendance> getByUserAndPeriod(String username, Date from, Date to) {
        return listToModel(attendanceRepostiry.getByUsernameAndPeriod(username, from, to));
    }

    @Override
    public void save(Attendance attendance) {
        AttendanceJPA attendanceJPA = attendanceToAttendanceJPA(attendance);
        
        attendanceRepostiry.persist(attendanceJPA);
    }    

    @Override
    public void delete(Long id) {
        attendanceRepostiry.deleteById(id);
    }

    private List<Attendance> listToModel(List<AttendanceJPA> attendancesJPA) {
        return attendancesJPA.stream()
            .map(attendanceJPA -> attendanceJPAtoAttendance(attendanceJPA))
            .collect(Collectors.toList());
    }

    private Attendance attendanceJPAtoAttendance(AttendanceJPA attendanceJPA) {
        return modelMapper.map(attendanceJPA,Attendance.class);
    }
    
    private AttendanceJPA attendanceToAttendanceJPA(Attendance attendance) {
        return modelMapper.map(attendance,AttendanceJPA.class);
    }
}
