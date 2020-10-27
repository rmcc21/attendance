package gov.mendoza.salud.hvt.attendance.model.attendance.repositories;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import gov.mendoza.salud.hvt.attendance.model.attendance.jpa.AttendanceJPA;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class AttendanceRepostiry implements PanacheRepository<AttendanceJPA>{
    public List<AttendanceJPA> getByUsername(String username) {
        return find("username",username).list();
    }

    public List<AttendanceJPA> getByUsernameAndPeriod(String username, Date from, Date to) {
        return find("select a from Attendance a where a.username=:username and a.from >= :from and a.to <= :to",
            Parameters.with("username", username).and("from", from).and("to", to).map())
            .list();
    }

}
