package mx.com.capacitacionhospital.paciente.external.jpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tho04_estado_cita")
public class EstadoCitaJpa {
    @Id
    @Column(name = "id_estado")
    private Integer id;
    @Column(name = "tx_nombre")
    private String nombre;
}
