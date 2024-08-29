package mx.com.capacitacionhospital.hospital.core.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HospitalMedico {
    private Integer idHospital;
    private Integer idMedico;
}
