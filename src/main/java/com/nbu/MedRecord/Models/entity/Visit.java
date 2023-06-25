package com.nbu.MedRecord.Models.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private LocalDateTime date; // This is the date of the visit

    @OneToOne(mappedBy = "visit", cascade = CascadeType.ALL)
    private Diagnosis diagnosis; // This is the diagnosis made during the visit

    @Column(nullable = false)
    private int sickLeaveDays; // This is the number of sick leave days prescribed during the visit

    @ManyToOne
    private PatientHistory patientHistory;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }


    public int getSickLeaveDays() {
        return sickLeaveDays;
    }

    public void setSickLeaveDays(int sickLeaveDays) {
        this.sickLeaveDays = sickLeaveDays;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }
}
