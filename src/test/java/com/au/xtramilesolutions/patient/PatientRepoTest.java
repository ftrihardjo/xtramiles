package com.au.xtramilesolutions.patient;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class PatientRepoTest {
    @Autowired
    private PatientRepo repo;
    @Test
    @Rollback(false)
    @Order(1)
    public void testAddPatient() {
        Patient patient = repo.save(new Patient("John Doe", null, "", "", ""));

        assertThat(patient.getId()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void testFindPatientByName() {
        Optional<Patient> patient = repo.findByName("John Doe");
        assertThat(patient.get().getName()).isEqualTo("John Doe");
    }
    @Test
    @Order(3)
    public void testFindPatientById() {
        Optional<Patient> patient = repo.findById(1l);
        assertThat(patient.get().getId()).isEqualTo(1l);
    }
    @Test
    @Order(4)
    public void testFindAllPatients() {
        List<Patient> patients = repo.findAll();
        assertThat(patients).size().isEqualTo(1);
        assertThat(patients.get(0).getName()).isEqualTo("John Doe");
    }
    @Test
    @Rollback(false)
    @Order(5)
    public void testUpdatePatient() {
        Optional<Patient> patient = repo.findByName("John Doe");
        patient.get().setPhoneNo("0123456789");
        repo.save(patient.get());
        Optional<Patient> updatedPatient = repo.findByName("John Doe");
        assertThat(updatedPatient.get().getPhoneNo()).isEqualTo("0123456789");
    }
    @Test
    @Rollback(false)
    @Order(6)
    public void testDeletePatient() {
        Optional<Patient> patient = repo.findByName("John Doe");
        repo.deleteById(patient.get().getId());
        Optional<Patient> deletedPatient = repo.findByName("John Doe");
        assertThat(deletedPatient).isEmpty();
    }
}