package mx.com.capacitacionhospital.medico.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "RegistroDeMedico", description = "Modelo utilizado para registrar un nuevo médico")
public class RegistroDeMedicoDto {

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

    @Schema(description = "Identificador del estado del médico")
    private Integer idEstado;

    @JsonProperty
    @Schema(description = "Lista de identificadores de hospitales asociados")
    private List<Integer> idHospitalesAsociados;


    public static RegistroDeMedicoDto fromEntity(Medico medico, List<Integer> idHospitalesAsociados) {
        return RegistroDeMedicoDto.builder()
                .idMedico(medico.getIdMedico())
                .nombre(medico.getNombre())
                .primerApellido(medico.getPrimerApellido())
                .segundoApellido(medico.getSegundoApellido())
                .idEstado(medico.getIdEstado())
                .idHospitalesAsociados(medico.getHospitalesAsociados())
                .build();
    }
}
