package com.nbu.MedRecord.services.impl;

import com.nbu.MedRecord.Models.entity.PatientHistory;
import com.nbu.MedRecord.repositories.PatientHistoryRepository;
import com.nbu.MedRecord.services.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private PatientHistoryRepository patientHistoryRepository;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository) {
        this.patientHistoryRepository = patientHistoryRepository;
    }

    public List<PatientHistory> getPatientHistory(Long patientId) {
        return patientHistoryRepository.findByPatientId(patientId);
    }

    // Other service methods as per your requirements...
}

