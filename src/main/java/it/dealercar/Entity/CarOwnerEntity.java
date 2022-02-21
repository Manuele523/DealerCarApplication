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
@Table(name = "T_CAR_OWNER")
public class CarOwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_ID")
    @SequenceGenerator(name="SG_ID", sequenceName="SQ_ID_CAR_OWNER", allocationSize=1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "FK_OWNER", nullable = false)
    private Long idOwner;

    @Column(name = "FK_MODEL", nullable = false)
    private Long idModel;

    @DateTimeFormat
    @Column(name = "PURCHASE_DATE", nullable = false)
    private Date purchaseDate;

    @DateTimeFormat
    @Column(name = "SELL_DATE", nullable = true)
    private Date sellDate;

    @DateTimeFormat
    @Column(name = "LAST_EDIT_DATE", nullable = false)
    private Date dateLastEdit;

    @Column(name = "PRACTICE_STATUS", nullable = false)
    private String statusPractice;

}
