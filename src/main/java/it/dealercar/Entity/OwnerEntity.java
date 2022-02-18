package it.dealercar.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_OWNER")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_ID")
    @SequenceGenerator(name="SG_ID", sequenceName="SQ_ID_OWNER", allocationSize=1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @DateTimeFormat
    @Column(name = "BIRTHDATE", nullable = false)
    private Date birthdate;

    @Column(name = "MAIL", nullable = false)
    private String mail;

}
