package mx.com.capacitacionhospital.paciente.external.jpa.repository;



import mx.com.capacitacionhospital.paciente.external.jpa.model.PacienteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteJpaRepository extends JpaRepository<PacienteJpa, Integer> {

    boolean existsById(Integer idPaciente);
    Optional<PacienteJpa> findByNombre(String nombre);
}
