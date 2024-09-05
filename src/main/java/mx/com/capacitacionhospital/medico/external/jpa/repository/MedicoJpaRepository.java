package mx.com.capacitacionhospital.medico.external.jpa.repository;



import mx.com.capacitacionhospital.medico.external.jpa.model.MedicoJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoJpaRepository extends JpaRepository<MedicoJpa, Integer> {

    boolean existsById(Integer idMedico);

    Optional<MedicoJpa> findByNombre(String nombre);

    List<MedicoJpa> findByIdEstado(Integer idEstado);
}
