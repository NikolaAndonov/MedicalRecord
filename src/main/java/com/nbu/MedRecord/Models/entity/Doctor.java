package com.nbu.MedRecord.Models.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialty;

    @OneToOne
    private User user;

    @OneToMany
    @Column(name = "personal_patients")
    private List<Patient> personalPatients;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Diagnosis> diagnoses;

    // ... setters and getters ...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPersonalDoctor() {
        return personalPatients;
    }

    public void setPersonalDoctor(List<Patient> personalDoctor) {
        this.personalPatients = personalDoctor;
    }


    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}


