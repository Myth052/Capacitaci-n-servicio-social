package mx.com.capacitacionhospital.hospital.core.entity;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Builder
@Getter
@Setter
public class Paciente {

    private Integer idPaciente;
    private String nombre;
    private String fecha;

    //private String nombreEstado;



    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(idPaciente, paciente.idPaciente);
    }
}
