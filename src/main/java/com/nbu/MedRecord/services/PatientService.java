package com.nbu.MedRecord.services;

import com.nbu.MedRecord.Models.entity.*;
import com.nbu.MedRecord.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {

    List<Diagnosis> getDiagnoses(Long patientId);

    List<Treatment> getTreatments(Long patientId);

    List<Visit> getPatientVisitHistory(Long patientId);

    List<Doctor> getDoctors(Long patientId);

    List<Patient> getAllPatients();

    void savePatient(Patient patient);

    Optional<Patient> getPatientById(Long id);
}