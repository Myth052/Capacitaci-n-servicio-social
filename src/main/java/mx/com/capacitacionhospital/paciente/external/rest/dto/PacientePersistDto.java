package mx.com.capacitacionhospital.paciente.external.rest.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PacientePersist", description = "Modelo utilizado para persistir la informacion del paciente")
public class PacientePersistDto {

    @JsonProperty
    @NotNull(message = "RNS001")
    @Size(min = 1, max = 150, message = "RNS002")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "RNS003")
    @Schema(description = "Nombre del paciente")
    private String nombre;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @Schema(description = "...", format = "string", implementation = String.class)
    private LocalDateTime fecha;



    public Paciente toEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String fechaFormatted = null;
        if (this.fecha != null) {
            fechaFormatted = this.fecha.format(formatter);
        }

        return Paciente.builder()
                .nombre(this.nombre)
                .fecha(fechaFormatted)
                .build();
    }


}
