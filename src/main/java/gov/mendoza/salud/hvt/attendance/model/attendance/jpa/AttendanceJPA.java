package gov.mendoza.salud.hvt.attendance.model.attendance.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class AttendanceJPA {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) public Long id;
    public String userLink;
    public Long latitude;
    public Long longitude;    
    @CreationTimestamp
    public Date datetime;
    @Enumerated(EnumType.STRING) public Type type;
    public String photo;

    public enum Type {
        IN, OUT
    }
}
