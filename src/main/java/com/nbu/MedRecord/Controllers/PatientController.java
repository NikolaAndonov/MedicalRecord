package com.nbu.MedRecord.Controllers;

import com.nbu.MedRecord.Models.entity.Patient;
import com.nbu.MedRecord.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Display list of patients
    @GetMapping("/patients")
    public String viewPatientsPage(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients"; // this refers to patients.html Thymeleaf template
    }


    // Add new patient form
    @GetMapping("/patients/new")
    public String showNewPatientPage(Model model) {
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "new_patient"; // this refers to new_patient.html Thymeleaf template
    }

    // Save patient to database
    @PostMapping("/patients")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }
}

