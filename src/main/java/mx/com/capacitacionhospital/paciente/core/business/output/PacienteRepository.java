package mx.com.capacitacionhospital.paciente.core.business.output;



import mx.com.capacitacionhospital.paciente.core.entity.Paciente;

import java.util.Optional;

public interface PacienteRepository {

    Optional<Paciente> findById(Integer idPaciente);

    Paciente save(Paciente paciente);

    Paciente update(Paciente paciente);

    void delete(Integer idPaciente);

    boolean existsById(Integer idPaciente);
}
