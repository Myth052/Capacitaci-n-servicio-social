package mx.com.capacitacionhospital.medico.external.jpa.model;

import lombok.*;

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
}
