package mx.com.capacitacionhospital.paciente.external.rest.controller;



import mx.com.capacitacionhospital.paciente.external.rest.dto.PacientePersistDto;
import mx.com.capacitacionhospital.util.error.ErrorMapper;
import mx.com.capacitacionhospital.paciente.core.business.input.PacienteService;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import mx.com.capacitacionhospital.paciente.external.rest.dto.PacienteDto;

import mx.com.capacitacionhospital.util.error.ErrorResponseDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Gestion de pacientes")
public class GestionPacientesController {

    @Inject
    PacienteService pacienteService;

    @PUT
    @Path("{idPaciente}")
    @Operation(operationId = "updatePaciente", description = "Actualiza la información del paciente")
    public Response updatePaciente(@PathParam("idPaciente") Integer idPaciente, @Valid PacientePersistDto pacientePersistDto) {
        return pacienteService.editarPaciente(idPaciente, pacientePersistDto.toEntity())
                .map(PacienteDto::fromEntity).map(Response::ok)
                .getOrElseGet(ErrorMapper::errorCodeToResponseBuilder)
                .build();
    }



    @DELETE
    @Path("{idPaciente}")
    @APIResponse(responseCode = "200", description = "Peticion exitosa", content = @Content(schema = @Schema(implementation = Boolean.class)))
    @APIResponse(responseCode = "400", description = "Error en la peticion", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    @APIResponse(responseCode = "404", description = "Error en la peticion", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    @Operation(operationId = "deletePaciente", description = "Se realizará la eliminación del paciente indicado")
    public Response deletePaciente(@PathParam("idPaciente") Integer idPaciente) {
        return pacienteService.eliminarPaciente(idPaciente)
                .map(Response::ok)
                .getOrElseGet(ErrorMapper::errorCodeToResponseBuilder)
                .build();
    }

}
