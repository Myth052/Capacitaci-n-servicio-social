package mx.com.capacitacionhospital.paciente.external.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Paciente", description = "Modelo utilizado para consultar la información de un paciente")
public class PacienteDto {

    @JsonProperty
    @Schema(description = "Identificador del paciente")
    private Integer idPaciente;

    @JsonProperty
    @Schema(description = "Nombre del paciente")
    private String nombre;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Schema(description = "Fecha de afiliación del paciente", format = "string", implementation = String.class)
    private LocalDateTime fecha;


}
