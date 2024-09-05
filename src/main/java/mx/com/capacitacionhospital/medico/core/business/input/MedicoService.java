package mx.com.capacitacionhospital.medico.core.business.input;

import io.vavr.control.Either;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import mx.com.capacitacionhospital.util.error.ErrorCodesEnum;

import java.util.List;

public interface MedicoService {

    Either<ErrorCodesEnum, List<Medico>> obtenerMedicosGestion();
    Either<ErrorCodesEnum, Boolean> registrarMedico(Medico medico);
}
