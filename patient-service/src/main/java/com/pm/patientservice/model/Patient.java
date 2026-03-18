package com.pm.patientservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID patientId;

  @NotNull
  private String fullName;

  @NotNull
  @Email
  @Column(unique = true)
  private String email;

  @NotNull
  private String address;

  @NotNull
  private LocalDate dob;

  @NotNull
  private LocalDate regDate;

  public UUID getPatientId() {
    return patientId;
  }

  public void setPatientId(UUID patientId) {
    this.patientId = patientId;
  }

  public @NotNull String getFullName() {
    return fullName;
  }

  public void setFullName(@NotNull String fullName) {
    this.fullName = fullName;
  }

  public @NotNull @Email String getEmail() {
    return email;
  }

  public void setEmail(@NotNull @Email String email) {
    this.email = email;
  }

  public @NotNull String getAddress() {
    return address;
  }

  public void setAddress(@NotNull String address) {
    this.address = address;
  }

  public @NotNull LocalDate getDob() {
    return dob;
  }

  public void setDob(@NotNull LocalDate dob) {
    this.dob = dob;
  }

  public @NotNull LocalDate getRegDate() {
    return regDate;
  }

  public void setRegDate(@NotNull LocalDate regDate) {
    this.regDate = regDate;
  }

}
