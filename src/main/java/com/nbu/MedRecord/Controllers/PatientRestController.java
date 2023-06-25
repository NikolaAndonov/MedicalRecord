package com.nbu.MedRecord.Controllers;

import com.nbu.MedRecord.Models.entity.*;
import com.nbu.MedRecord.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientRestController {

    private final PatientService patientService;

    @Autowired
    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String showAllPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients";
    }


    @GetMapping("/{id}/diagnoses")
    public ResponseEntity<List<Diagnosis>> getPatientDiagnoses(@PathVariable Long id) {
        List<Diagnosis> diagnoses = patientService.getDiagnoses(id);
        return new ResponseEntity<>(diagnoses, HttpStatus.OK);
    }

    @GetMapping("/{id}/treatments")
    public ResponseEntity<List<Treatment>> getPatientTreatments(@PathVariable Long id) {
        List<Treatment> treatments = patientService.getTreatments(id);
        return new ResponseEntity<>(treatments, HttpStatus.OK);
    }

    @GetMapping("/{id}/visits")
    public ResponseEntity<List<Visit>> getPatientVisits(@PathVariable Long id) {
        List<Visit> visits = patientService.getPatientVisitHistory(id);
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    @GetMapping("/{id}/doctors")
    public ResponseEntity<List<Doctor>> getPatientDoctors(@PathVariable Long id) {
        List<Doctor> doctors = patientService.getDoctors(id);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/patients/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/edit/{id}")
    public String showEditPatientForm(@PathVariable("id") Long id, Model model) {
        Optional<Patient> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "edit-patient";
        } else {
            // handle error when patient not found
            return "redirect:/patients";
        }
    }

    @PostMapping("/patients/edit")
    public String editPatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/history/{id}")
    public String showPatientHistory(@PathVariable("id") Long id, Model model) {
        Optional<Patient> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "patient-history";
        } else {
            // handle error when patient not found
            return "redirect:/patients";
        }
    }


}
