package mx.com.capacitacionhospital.medico.core.business.implementation;


import io.vavr.control.Either;
import lombok.extern.slf4j.Slf4j;
import mx.com.capacitacionhospital.hospital.core.entity.HospitalMedico;
import mx.com.capacitacionhospital.medico.core.business.input.MedicoService;
import mx.com.capacitacionhospital.medico.core.business.output.MedicoRepository;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import mx.com.capacitacionhospital.medico.core.statemachine.MedicoSM;
import mx.com.capacitacionhospital.util.error.ErrorCodesEnum;
import mx.com.capacitacionhospital.hospital.external.jpa.repository.HospitalMedicoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class MedicoBs implements MedicoService {

    @Inject
    MedicoRepository medicoRepository;

    @Inject
    MedicoSM medicoSM;

    @Override
    public Either<ErrorCodesEnum, List<Medico>> obtenerMedicosGestion() {
        List<Medico> medicos = medicoRepository.findAll();

        if (medicos.isEmpty()) {
            log.error("No se encontraron médicos.");
            return Either.left(ErrorCodesEnum.NOT_FOUND);
        }
        medicos.forEach(medico -> {
            var estado = medicoSM.getStateById(medico.getIdEstado());
            medico.setPuedeEditar(medicoSM.isDoable(medicoSM.getEditar(), estado));
            medico.setPuedeEliminar(medicoSM.isDoable(medicoSM.getEliminar(), estado));
            medico.setPuedeConsultarHospitalesAsociados(medicoSM.isDoable(medicoSM.getConsultarHospitales(), estado));
        });

        return Either.right(medicos);
    }



    @Override
    public Either<ErrorCodesEnum, Boolean> registrarMedico(Medico medico) {
        try {
            Optional<Medico> medicoExistente = medicoRepository.findByNombre(medico.getNombre());
            if (medicoExistente.isPresent()) {
                return Either.left(ErrorCodesEnum.RNN007);
            }
            medicoRepository.save(medico);

            return Either.right(true);
        } catch (PersistenceException e) {
            return Either.left(ErrorCodesEnum.ERROR);
        }
    }

}
