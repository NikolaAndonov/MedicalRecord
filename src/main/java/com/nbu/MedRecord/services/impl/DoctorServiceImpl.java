package com.nbu.MedRecord.services.impl;

import com.nbu.MedRecord.Models.entity.Doctor;
import com.nbu.MedRecord.Models.entity.Visit;
import com.nbu.MedRecord.exceptions.NotFoundException;
import com.nbu.MedRecord.repositories.DoctorRepository;
import com.nbu.MedRecord.services.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {


    private final DoctorRepository doctorRepository;

    // Constructor with dependency injection
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Visit> getDoctorVisitHistory(Long doctorId) {
        // This method will return all the visits of a specific doctor
        //return doctorRepository.findById(doctorId).get().getVisits();
        return null;
    }

    public Doctor getDoctorById(Long id) throws NotFoundException {
        return doctorRepository.findById(id).orElseThrow(() -> new NotFoundException("Doctor not found"));
    }

    public Doctor createDoctor(Doctor doctor) {
        // You can add validation logic here
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) throws NotFoundException {
        // You can add validation and other logic here
        Doctor existingDoctor = getDoctorById(id);
        existingDoctor.setName(doctor.getName());
        // Update other fields...
        return doctorRepository.save(existingDoctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public void saveDoctor(Doctor doctor) {

    }

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    /*public int getNumberOfPatients(Long doctorId) {
        // This method will return the number of patients of a specific doctor
        return doctorRepository.findById(doctorId).get().getPatients().size();
    }*/

    // More methods...

}
