package mx.com.capacitacionhospital.paciente.external.jpa.repository;



import mx.com.capacitacionhospital.paciente.external.jpa.model.PacienteJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PacienteJpaRepository extends JpaRepository<PacienteJpa, Integer> {

//    @Query("SELECT p FROM PacienteJpa p WHERE p.id = :id")
//    Optional<PacienteJpa> findByIdPaciente(@Param("id") Integer id);

    boolean existsById(Integer idPaciente);
}
