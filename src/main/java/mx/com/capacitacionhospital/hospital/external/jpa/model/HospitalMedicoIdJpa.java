package mx.com.capacitacionhospital.hospital.external.jpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class HospitalMedicoIdJpa implements Serializable {
    @Column(name = "fk_id_hospital", nullable = false)
    private Integer idHospital;
    @Column(name = "fk_id_medico", nullable = false)
    private Integer idMedico;
}
