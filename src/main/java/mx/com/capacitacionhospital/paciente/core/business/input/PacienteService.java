
package mx.com.capacitacionhospital.paciente.core.business.input;



import io.vavr.control.Either;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import mx.com.capacitacionhospital.util.error.ErrorCodesEnum;

import java.util.List;


public interface PacienteService {
    Either<ErrorCodesEnum, Paciente> editarPaciente(Integer idPaciente, Paciente entity);

    Either<ErrorCodesEnum, Boolean> eliminarPaciente(Integer idPaciente);
}



