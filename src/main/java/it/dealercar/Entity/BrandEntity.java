package it.dealercar.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_BRAND")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_ID")
    @SequenceGenerator(name="SG_ID", sequenceName="SQ_ID_BRAND", allocationSize=1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String CODE;

    @Column(name = "TITLE", nullable = false)
    private String title;

}
