package mx.com.capacitacionhospital.paciente.core.business.implementation;


import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;
import mx.com.capacitacionhospital.paciente.core.business.input.PacienteService;
import mx.com.capacitacionhospital.paciente.core.business.output.PacienteRepository;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import mx.com.capacitacionhospital.util.error.ErrorCodesEnum;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class PacienteBs implements PacienteService {

    @Inject
    PacienteRepository pacienteRepository;

    @Override
    public Either<ErrorCodesEnum, Paciente> editarPaciente(Integer idPaciente, Paciente entity) {
        Either<ErrorCodesEnum, Paciente> result = Either.left(ErrorCodesEnum.NOT_FOUND);
        var existsPaciente = pacienteRepository.findById(idPaciente);

        if (existsPaciente.isPresent()) {
            var pacienteActualizar = existsPaciente.get();
            log.info("Se actualizará el paciente con ID {}: Nombre actual: {} y nuevo nombre: {}", idPaciente, pacienteActualizar.getNombre(), entity.getNombre());
            pacienteActualizar.setNombre(entity.getNombre());
            pacienteActualizar.setFecha(entity.getFecha());
            result = Either.right(pacienteRepository.update(pacienteActualizar));
        } else {
            log.error("No se encontró el paciente con ID: {}", idPaciente);
        }

        return result;
    }




    @Override
    public Either<ErrorCodesEnum, Boolean> eliminarPaciente(Integer idPaciente) {
        try {
            Optional<Paciente> pacienteOpt = pacienteRepository.findById(idPaciente);
            if (pacienteOpt.isPresent()) {
                pacienteRepository.delete(idPaciente);
                return Either.right(true);
            } else {
                log.error("No se encontró el paciente con ID: {}", idPaciente);
                return Either.left(ErrorCodesEnum.RNN002);
            }

        } catch (Exception e) {
            log.error("No se pudo eliminar el paciente con ID: {} debido a que tiene citas asociadas.", idPaciente, e);
            return Either.left(ErrorCodesEnum.RNN004);
        }
    }





}


//pasar como query param el nombre completo
