package mx.com.capacitacionhospital.paciente.external.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho06_paciente")
public class PacienteJpa {
    @Id
    @SequenceGenerator(name = "tho06_paciente_id_paciente_seq", sequenceName = "tho06_paciente_id_paciente_seq", allocationSize = 1)
    @GeneratedValue(generator = "tho06_paciente_id_paciente_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_paciente")
    private Integer id;
    @Column(name = "tx_nombre")
    private String nombre;
    @Column(name = "fh_afiliacion")
    private LocalDateTime fechaAfiliacion;
}
