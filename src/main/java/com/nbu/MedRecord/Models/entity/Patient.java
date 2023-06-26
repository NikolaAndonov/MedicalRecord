package com.nbu.MedRecord.Models.entity;


import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String identificationNumber;  // This is the EGN

    @Column(nullable = false)
    private boolean insurancePaid; // This indicates whether the patient has paid their health insurance in the last 6 months

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor personalDoctor; // This is the patient's personal doctor


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

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public boolean isInsurancePaid() {
        return insurancePaid;
    }

    public void setInsurancePaid(boolean insurancePaid) {
        this.insurancePaid = insurancePaid;
    }

    public Doctor getPersonalDoctor() {
        return personalDoctor;
    }

    public void setPersonalDoctor(Doctor personalDoctor) {
        this.personalDoctor = personalDoctor;
    }

}
