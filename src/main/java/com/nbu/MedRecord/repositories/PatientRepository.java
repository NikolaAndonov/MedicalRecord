package com.nbu.MedRecord.repositories;

import com.nbu.MedRecord.Models.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long>, JpaSpecificationExecutor<Patient> {
    List<Patient> findByIdentificationNumber(String identNum);
}
