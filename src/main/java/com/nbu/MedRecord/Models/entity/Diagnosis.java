package com.nbu.MedRecord.Models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "treatment_id", nullable = false)
    private Treatment treatment;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    @Column(nullable = false)
    private String description; // This is the description of the diagnosis

    @OneToOne
    @JoinColumn(name = "visit_id", nullable = false)
    private Visit visit; // This is the visit during which the diagnosis was made


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}