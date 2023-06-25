package com.nbu.MedRecord.repositories;

import com.nbu.MedRecord.Models.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
