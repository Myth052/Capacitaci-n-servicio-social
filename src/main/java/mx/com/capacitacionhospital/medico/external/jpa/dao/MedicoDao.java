package mx.com.capacitacionhospital.medico.external.jpa.dao;


import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoIdJpa;
import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoJpa;
import mx.com.capacitacionhospital.hospital.external.jpa.repository.HospitalMedicoRepository;
import mx.com.capacitacionhospital.medico.core.business.output.MedicoRepository;
import mx.com.capacitacionhospital.medico.core.entity.Medico;
import mx.com.capacitacionhospital.medico.external.jpa.model.MedicoJpa;
import mx.com.capacitacionhospital.medico.external.jpa.repository.MedicoJpaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@ApplicationScoped
public class MedicoDao implements MedicoRepository {

    @Inject
    MedicoJpaRepository medicoJpaRepository;

    @Inject
    HospitalMedicoRepository hospitalMedicoRepository;


    @Override
    public List<Medico> findAll() {
        return medicoJpaRepository.findAll().stream()
                .map(MedicoJpa::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Medico save(Medico medico) {
        MedicoJpa medicoJpa = MedicoJpa.fromEntity(medico);
        MedicoJpa savedMedico = medicoJpaRepository.saveAndFlush(medicoJpa);
        medico.getHospitalesAsociados().forEach(idHospital -> {
            HospitalMedicoJpa hospitalMedicoJpa = HospitalMedicoJpa.builder()
                    .id(HospitalMedicoIdJpa.builder()
                            .idHospital(idHospital)
                            .idMedico(savedMedico.getIdMedico())
                            .build())
                    .build();
            hospitalMedicoRepository.save(hospitalMedicoJpa);
        });

        return savedMedico.toEntity();
    }

    @Override
    public Optional<Medico> findByNombre(String nombre) {
        return medicoJpaRepository.findByNombre(nombre).map(MedicoJpa::toEntity);
    }
}
