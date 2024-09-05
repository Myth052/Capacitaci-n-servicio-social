package mx.com.capacitacionhospital.medico.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "RegistroDeMedico", description = "Modelo utilizado para registrar la informacion de un medico")
public class RegistroDeMedicoPersistDto {

    @JsonProperty
    @NotNull(message = "RNS001")
    @Size(min = 1, max = 100, message = "RNS002")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "RNS003")
    @Schema(description = "Nombre del médico")
    private String nombre;

    @JsonProperty
    @NotNull(message = "RNS001")
    @Size(min = 1, max = 100, message = "RNS002")
    @Schema(description = "Primer apellido del médico")
    private String primerApellido;

    @JsonProperty
    @Size(min = 1, max = 100, message = "RNS002")
    @Schema(description = "Segundo apellido del médico")
    private String segundoApellido;

    @JsonProperty
    @NotNull(message = "RNS001")
    @Schema(description = "Identificador del estado del médico")
    private Integer idEstado;

    @JsonProperty
    @NotEmpty(message = "RNS006")
    @Schema(description = "Lista de hospitales asociados al médico")
    private List<Integer> idHospitalesAsociados;

    public Medico toEntity() {
        return Medico.builder()
                .nombre(nombre)
                .primerApellido(primerApellido)
                .segundoApellido(segundoApellido)
                .idEstado(idEstado)
                .hospitalesAsociados(idHospitalesAsociados)
                .build();
    }
}
