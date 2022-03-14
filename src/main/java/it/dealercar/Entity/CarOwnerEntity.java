package it.dealercar.Entity;

import it.dealercar.Enum.StatusPractice;
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
    @SequenceGenerator(name = "SG_ID", sequenceName = "SQ_ID_CAR_OWNER", allocationSize = 1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_OWNER", referencedColumnName = "ID")
    private OwnerEntity owner;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_MODEL", referencedColumnName = "ID")
    private ModelEntity model;

    @DateTimeFormat
    @Column(name = "PURCHASE_DATE", nullable = false)
    private Date purchaseDate;

    @DateTimeFormat
    @Column(name = "SELL_DATE", nullable = true)
    private Date sellDate;

    @DateTimeFormat
    @Column(name = "DATE_LAST_EDIT", nullable = false)
    private Date dateLastEdit;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRACTICE_STATUS", nullable = false)
    private StatusPractice statusPractice;

}
