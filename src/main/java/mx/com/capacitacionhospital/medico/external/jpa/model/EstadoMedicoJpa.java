package mx.com.capacitacionhospital.medico.external.jpa.model;


import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho07_estado_medico")
public class EstadoMedicoJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "tx_nombre")
    private String nombreEstado;
}
