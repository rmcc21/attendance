package gov.mendoza.salud.hvt.attendance.model.attendance;

import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Attendance {
    public Long id;
    public String userLink;
    public Long latitude;
    public Long longitude;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    public Date datetime;
    public Type type;
    public String photo;

    public enum Type {
        IN, OUT
    }
}

