package mx.com.capacitacionhospital.paciente.external.jpa.dao;


import mx.com.capacitacionhospital.paciente.core.business.output.PacienteRepository;
import mx.com.capacitacionhospital.paciente.core.entity.Paciente;
import mx.com.capacitacionhospital.paciente.external.jpa.model.PacienteJpa;
import mx.com.capacitacionhospital.paciente.external.jpa.repository.PacienteJpaRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


import java.util.Optional;


@ApplicationScoped
public class PacienteDao implements PacienteRepository {

    @Inject
    PacienteJpaRepository pacienteJpaRepository;

    @Override
    public Optional<Paciente> findById(Integer idPaciente) {
        return pacienteJpaRepository.findById(idPaciente).map(PacienteJpa::toEntity);
    }

    @Override
    public Paciente save(Paciente paciente) {
        PacienteJpa pacienteJpa = PacienteJpa.fromEntity(paciente);
        return pacienteJpaRepository.saveAndFlush(pacienteJpa).toEntity();
    }

    @Override
    public Paciente update(Paciente paciente) {
        PacienteJpa pacienteJpa = PacienteJpa.fromEntity(paciente);
        return pacienteJpaRepository.saveAndFlush(pacienteJpa).toEntity();
    }


    @Override
    public void delete(Integer idPaciente) {
        pacienteJpaRepository.deleteById(idPaciente);
    }

    @Override
    public boolean existsById(Integer idPaciente) {
        return pacienteJpaRepository.existsById(idPaciente);
    }
}
