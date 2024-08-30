package mx.com.capacitacionhospital.paciente.external.jpa.model;

import lombok.*;
import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalJpa;
import mx.com.capacitacionhospital.medico.external.jpa.model.MedicoJpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho05_cita")
public class CitaJpa {
    @Id
    @SequenceGenerator(name = "tho05_cita_id_cita_seq", sequenceName = "tho05_cita_id_cita_seq", allocationSize = 1)
    @GeneratedValue(generator = "tho05_cita_id_cita_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cita")
    private Integer id;
    @Column(name = "fk_id_hospital")
    private Integer idHospital;
    @Column(name = "fk_id_medico")
    private Integer idMedico;
    @Column(name = "fk_id_paciente")
    private Integer idPaciente;
    @Column(name = "fk_id_estado")
    private Integer idEstado;
    @Column(name = "fh_cita")
    private LocalDateTime fechaCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_hospital", referencedColumnName = "id_hospital", insertable = false, updatable = false)
    private HospitalJpa hospital;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_medico", referencedColumnName = "id_medico", insertable = false, updatable = false)
    private MedicoJpa medico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_paciente", referencedColumnName = "id_paciente", insertable = false, updatable = false)
    private PacienteJpa paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false)
    private EstadoCitaJpa estadoCita;
}
