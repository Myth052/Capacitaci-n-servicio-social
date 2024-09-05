package mx.com.capacitacionhospital.medico.external.jpa.model;

import lombok.*;
import mx.com.capacitacionhospital.hospital.core.entity.HospitalMedico;
import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoIdJpa;
import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoJpa;
import mx.com.capacitacionhospital.medico.core.entity.Medico;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    private Integer idMedico;

    @Column(name = "tx_nombre")
    private String nombre;

    @Column(name = "tx_primer_apellido")
    private String primerApellido;

    @Column(name = "tx_segundo_apellido")
    private String segundoApellido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_estado", referencedColumnName = "id_estado")
    private EstadoMedicoJpa idEstado;

    @OneToMany(mappedBy = "idMedico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospitalMedicoJpa> hospitalesAsociados;

    public static MedicoJpa fromEntity(Medico medico) {
        return MedicoJpa.builder()
                .idMedico(medico.getIdMedico())
                .nombre(medico.getNombre())
                .primerApellido(medico.getPrimerApellido())
                .segundoApellido(medico.getSegundoApellido())
                .idEstado(EstadoMedicoJpa.builder()
                        .idEstado(medico.getIdEstado())
                        .nombreEstado(medico.getNombreEstado())
                        .build())
                .build();
    }

    public Medico toEntity() {
        return Medico.builder()
                .idMedico(this.idMedico)
                .nombre(this.nombre)
                .primerApellido(this.primerApellido)
                .segundoApellido(this.segundoApellido)
                .idEstado(this.idEstado != null ? this.idEstado.getIdEstado() : null)
                .nombreEstado(this.idEstado != null ? this.idEstado.getNombreEstado() : null)
                .hospitalesAsociados(this.hospitalesAsociados != null ?
                        this.hospitalesAsociados.stream()
                                .map(hospitalJpa -> hospitalJpa.getId().getIdHospital())
                                .collect(Collectors.toList()) : Collections.emptyList())
                .build();
    }

}
