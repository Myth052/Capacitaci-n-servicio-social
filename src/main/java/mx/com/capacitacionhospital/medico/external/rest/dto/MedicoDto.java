package mx.com.capacitacionhospital.medico.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "MedicoGestion", description = "Modelo utilizado para la gestión de un médico")
public class MedicoDto {

    @JsonProperty
    @Schema(description = "Identificador del médico")
    private Integer idMedico;

    @JsonProperty
    @Schema(description = "Nombre del médico")
    private String nombre;

    @JsonProperty
    @Schema(description = "Primer apellido del médico")
    private String primerApellido;

    @JsonProperty
    @Schema(description = "Segundo apellido del médico")
    private String segundoApellido;

    @JsonProperty
    @Schema(description = "Indica si el médico puede ser editado")
    private boolean puedeEditar;

    @JsonProperty
    @Schema(description = "Indica si el médico puede ser eliminado")
    private boolean puedeEliminar;

    @JsonProperty
    @Schema(description = "Indica si se pueden consultar los hospitales asociados al médico")
    private boolean puedeConsultarHospitalesAsociados;

    @JsonProperty
    @Schema(description = "Identificador del estado del médico")
    private Integer idEstado;

    public static MedicoDto fromEntity(Medico medico, boolean puedeEditar, boolean puedeEliminar, boolean puedeConsultarHospitalesAsociados) {
        return MedicoDto.builder()
                .idMedico(medico.getIdMedico())
                .nombre(medico.getNombre())
                .primerApellido(medico.getPrimerApellido())
                .segundoApellido(medico.getSegundoApellido())
                .puedeEditar(puedeEditar)
                .puedeEliminar(puedeEliminar)
                .puedeConsultarHospitalesAsociados(puedeConsultarHospitalesAsociados)
                .idEstado(medico.getIdEstado())
                .build();
    }
}
