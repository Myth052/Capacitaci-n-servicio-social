package mx.com.capacitacionhospital.medico.external.rest.controller;

import mx.com.capacitacionhospital.medico.external.rest.dto.MedicoDto;
import mx.com.capacitacionhospital.medico.external.rest.dto.RegistroDeMedicoPersistDto;
import mx.com.capacitacionhospital.util.error.ErrorMapper;
import mx.com.capacitacionhospital.medico.core.business.input.MedicoService;
import mx.com.capacitacionhospital.util.error.ErrorResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/medicos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Gestión de Médicos")
public class GestionMedicosController {

    @Inject
    MedicoService medicoService;


    @GET
    @Path("/gestion")
    @Operation(operationId = "obtenerMedicosGestion", description = "Obtiene la lista de médicos para gestionar")
    @APIResponse(responseCode = "200", description = "Petición exitosa", content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = MedicoDto.class)))
    @APIResponse(responseCode = "400", description = "Error en la petición", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    public Response obtenerMedicosGestion() {
        return medicoService.obtenerMedicosGestion()
                .map(medicos -> Response.ok(medicos).build())
                .getOrElseGet(errorCode -> ErrorMapper.errorCodeToResponseBuilder(errorCode).build());
    }

    @POST
    @Path("/registrar")
    @Operation(operationId = "registrarMedico", description = "Registra un nuevo médico con los datos proporcionados")
    @APIResponse(responseCode = "200", description = "Registro exitoso", content = @Content(schema = @Schema(implementation = Boolean.class)))
    @APIResponse(responseCode = "400", description = "Error en la petición", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    public Response registrarMedico(@Valid RegistroDeMedicoPersistDto registroDeMedicoPersistDto) {
        return medicoService.registrarMedico(registroDeMedicoPersistDto.toEntity())
                .map(success -> Response.ok(success).build())
                .getOrElseGet(errorCode -> ErrorMapper.errorCodeToResponseBuilder(errorCode).build());
    }
}
