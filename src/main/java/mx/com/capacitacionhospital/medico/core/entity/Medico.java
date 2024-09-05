package mx.com.capacitacionhospital.medico.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


import java.util.Objects;

@Builder
@Getter
@Setter
public class Medico {

    private Integer idMedico;
    private Integer idEstado;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreEstado;

    private Boolean puedeEditar;
    private Boolean puedeEliminar;
    private Boolean puedeConsultarHospitalesAsociados;

    private List<Integer> hospitalesAsociados;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(idMedico, medico.idMedico);
    }

}
