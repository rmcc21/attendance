package gov.mendoza.salud.hvt.attendance.model.attendance.resources;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import gov.mendoza.salud.hvt.attendance.model.attendance.Attendance;
import gov.mendoza.salud.hvt.attendance.model.attendance.connectors.AttendanceConnector;

@Path("/attendance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AttendanceResource {
    @Inject AttendanceConnector attendanceConnector;
    
    @GET
    public List<Attendance> list() {
        return attendanceConnector.get();
    }

    @POST @Transactional
    public void save(Attendance attendance) {
        attendance.id=null;
        attendance.datetime=null;
        attendanceConnector.save(attendance);
    }
}
