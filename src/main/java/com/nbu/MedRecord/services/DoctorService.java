package com.nbu.MedRecord.services;

import com.nbu.MedRecord.Models.entity.Doctor;
import com.nbu.MedRecord.exceptions.NotFoundException;

import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(Long id) throws NotFoundException;

    Doctor createDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor doctor) throws NotFoundException;

    void deleteDoctor(Long id);

    void saveDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

}
