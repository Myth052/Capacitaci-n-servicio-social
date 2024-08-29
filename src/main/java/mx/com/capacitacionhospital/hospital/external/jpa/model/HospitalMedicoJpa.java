package mx.com.capacitacionhospital.hospital.external.jpa.model;

import lombok.*;
import mx.com.capacitacionhospital.hospital.core.entity.HospitalMedico;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho03_hospital_medico")
public class HospitalMedicoJpa {
    @EmbeddedId
    private HospitalMedicoIdJpa id;
    @Column(name = "fk_id_hospital", insertable = false, updatable = false)
    private Integer idHospital;
    @Column(name = "fk_id_medico", insertable = false, updatable = false)
    private Integer idMedico;

    public static HospitalMedicoJpa fromEntity(HospitalMedico entity) {
        return HospitalMedicoJpa.builder()
                .id(HospitalMedicoIdJpa.builder()
                        .idHospital(entity.getIdHospital())
                        .idMedico(entity.getIdMedico())
                        .build())
                .idHospital(entity.getIdHospital())
                .idMedico(entity.getIdMedico())
                .build();
    }
}
