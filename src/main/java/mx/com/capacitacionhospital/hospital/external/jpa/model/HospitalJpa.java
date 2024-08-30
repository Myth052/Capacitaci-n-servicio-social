package mx.com.capacitacionhospital.hospital.external.jpa.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho01_hospital")
public class HospitalJpa {
    @Id
    @SequenceGenerator(name = "tho01_hospital_id_hospital_seq", sequenceName = "tho01_hospital_id_hospital_seq", allocationSize = 1)
    @GeneratedValue(generator = "tho01_hospital_id_hospital_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_hospital")
    private Integer id;
    @Column(name = "tx_nombre")
    private String nombre;
    @Column(name = "st_activa")
    private Boolean activo;
}
