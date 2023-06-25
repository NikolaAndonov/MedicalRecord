package com.nbu.MedRecord.services;

import com.nbu.MedRecord.Models.entity.PatientHistory;

import java.util.List;

public interface PatientHistoryService {

    List<PatientHistory> getPatientHistory(Long patientId);
}