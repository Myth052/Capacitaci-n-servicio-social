
package mx.com.capacitacionhospital.paciente.core.business.input;



import io.vavr.control.Either;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import mx.com.capacitacionhospital.util.error.ErrorCodesEnum;




public interface PacienteService {
    Either<ErrorCodesEnum, Boolean> editarPaciente(Integer idPaciente, Paciente entity);

    Either<ErrorCodesEnum, Boolean> eliminarPaciente(Integer idPaciente);
}



