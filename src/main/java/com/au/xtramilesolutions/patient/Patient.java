package com.au.xtramilesolutions.patient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private Date birthDate;
    private String address;
    private String phoneNo;
    private String gender;

    public Patient() {
    }

    public Patient(String name, Date birthDate, String address, String phoneNo, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }
}
