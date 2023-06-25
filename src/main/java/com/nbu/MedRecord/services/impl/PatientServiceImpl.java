package com.nbu.MedRecord.services.impl;

import com.nbu.MedRecord.Models.entity.*;
import com.nbu.MedRecord.repositories.PatientRepository;
import com.nbu.MedRecord.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Diagnosis> getDiagnoses(Long patientId) {
        // Реализация ...
        return null;
    }

    @Override
    public List<Treatment> getTreatments(Long patientId) {
        // Реализация ...
        return null;
    }

    @Override
    public List<Visit> getPatientVisitHistory(Long patientId) {
        // This method will return all the visits of a specific patient
        //return patientRepository.findById(patientId).get();
        return null;
    }

    @Override
    public List<Doctor> getDoctors(Long patientId) {
        // Реализация ...
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        return Collections.unmodifiableList(this.patientRepository.findAll());
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return this.patientRepository.findById(id);
    }
}
