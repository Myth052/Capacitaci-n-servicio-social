package mx.com.capacitacionhospital.hospital.external.jpa.repository;


import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoJpa;
import mx.com.capacitacionhospital.hospital.external.jpa.model.HospitalMedicoIdJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalMedicoRepository extends JpaRepository<HospitalMedicoJpa, HospitalMedicoIdJpa> {

}
