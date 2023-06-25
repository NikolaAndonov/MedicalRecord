package com.nbu.MedRecord.Controllers;

import com.nbu.MedRecord.Models.entity.Doctor;
import com.nbu.MedRecord.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Display list of doctors
    @GetMapping("/doctors")
    public String viewDoctorsPage(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors"; // this refers to doctors.html Thymeleaf template
    }

    // Add new doctor form
    @GetMapping("/doctors/new")
    public String showNewDoctorPage(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "new_doctor"; // this refers to new_doctor.html Thymeleaf template
    }

    // Save doctor to database
    @PostMapping("/doctors/save") // change this to /doctors/save
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
}

