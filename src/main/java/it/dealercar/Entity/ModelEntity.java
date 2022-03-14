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
@Table(name = "T_MODEL")
public class ModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_ID")
    @SequenceGenerator(name = "SG_ID", sequenceName = "SQ_ID_MODEL", allocationSize = 1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String CODE;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_BRAND", referencedColumnName = "ID")
    private BrandEntity brand;

    public ModelEntity(Long idModel) {
        this.id = idModel;
    }
}
