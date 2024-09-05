package mx.com.capacitacionhospital.medico.core.business.output;

import mx.com.capacitacionhospital.medico.core.entity.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository {

    List<Medico> findAll();

    Medico save(Medico medico);

    Optional<Medico> findByNombre(String nombre);
}
