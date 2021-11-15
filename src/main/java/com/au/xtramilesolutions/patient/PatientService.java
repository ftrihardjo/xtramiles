package com.au.xtramilesolutions.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }
    public List<Patient> findAllPatients() {
        return patientRepo.findAll();
    }
    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }
    public Patient findPatientById(Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + id + " is not found."));
    }
    public Patient findPatientByName(String name) {
        return patientRepo.findByName(name)
                .orElseThrow(() -> new PatientNotFoundException("Patient with name " + name + " is not found."));
    }
}
