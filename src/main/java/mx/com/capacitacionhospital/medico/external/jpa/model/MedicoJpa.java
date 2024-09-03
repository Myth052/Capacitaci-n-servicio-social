package mx.com.capacitacionhospital.medico.external.jpa.model;

import lombok.*;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoJpa;

import javax.persistence.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho02_medico")
public class MedicoJpa {
    @Id
    @SequenceGenerator(name = "tho02_medico_id_medico_seq", sequenceName = "tho02_medico_id_medico_seq", allocationSize = 1)
    @GeneratedValue(generator = "tho02_medico_id_medico_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_medico")
    private Integer id;

    @Column(name = "tx_nombre")
    private String nombre;

    @Column(name = "tx_primer_apellido")
    private String primerApellido;

    @Column(name = "tx_segundo_apellido")
    private String segundoApellido;

    public static MedicoJpa fromEntity(Medico medico) {
        return MedicoJpa.builder()
                .id(medico.getIdMedico())
                .nombre(medico.getNombre())
                .primerApellido(medico.getPrimerApellido())
                .segundoApellido(medico.getSegundoApellido())
                .build();
    }

    public Medico toEntity() {
        return Medico.builder()
                .idMedico(this.id)
                .nombre(this.nombre)
                .primerApellido(this.primerApellido)
                .segundoApellido(this.segundoApellido)
                .build();
    }
}
