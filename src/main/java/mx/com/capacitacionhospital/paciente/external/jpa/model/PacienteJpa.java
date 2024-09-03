package mx.com.capacitacionhospital.paciente.external.jpa.model;

import lombok.*;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false)
    private EstadoCitaJpa estado;

    public static PacienteJpa fromEntity(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("El objeto Paciente no puede ser null");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime fecha = null;
        if (paciente.getFecha() != null && !paciente.getFecha().isEmpty()) {
            try {
                fecha = LocalDateTime.parse(paciente.getFecha(), formatter);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato de fecha inválido para el paciente: " + paciente.getFecha(), e);
            }
        }

        return PacienteJpa.builder()
                .id(paciente.getIdPaciente())
                .nombre(paciente.getNombre())
                .fecha(fecha)
                .build();
    }

    public Paciente toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String fecha = null;
        if (this.fecha != null) {
            fecha = this.fecha.format(formatter);
        }

        return Paciente.builder()
                .idPaciente(this.id)
                .nombre(this.nombre)
                .fecha(fecha)
                .build();
    }
}
