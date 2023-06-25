package com.nbu.MedRecord.Controllers;

import com.nbu.MedRecord.Models.entity.PatientHistory;
import com.nbu.MedRecord.services.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PatientHistoryController {
    private PatientHistoryService patientHistoryService;

    @Autowired
    public PatientHistoryController(PatientHistoryService patientHistoryService) {
        this.patientHistoryService = patientHistoryService;
    }

    @GetMapping("/patients/{id}/history")
    public String getPatientHistory(@PathVariable Long id, Model model) {
        List<PatientHistory> patientHistory = patientHistoryService.getPatientHistory(id);
        model.addAttribute("patientHistory", patientHistory);
        return "patient_history"; // this refers to patient_history.html Thymeleaf template
    }
}

