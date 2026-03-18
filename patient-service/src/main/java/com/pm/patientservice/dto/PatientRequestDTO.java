package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

  @NotBlank(message = "Full name is required")
  @Size(max = 100, message = "Full name cannot exceed 100 characters")
  private String fullName;

  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  private String email;

  @NotBlank(message = "Address is required")
  private String address;

  @NotBlank(message = "Date of birth is required")
  private String dob;

  @NotBlank(groups = CreatePatientValidationGroup.class, message =
      "Registered date is required")
  private String regDate;

  public @NotBlank(message = "Full name is required") @Size(max = 100, message = "Full name cannot exceed 100 characters") String getFullName() {
    return fullName;
  }

  public void setFullName(
      @NotBlank(message = "Full name is required") @Size(max = 100, message = "Full name cannot exceed 100 characters") String fullName) {
    this.fullName = fullName;
  }

  public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
    return email;
  }

  public void setEmail(
      @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
    this.email = email;
  }

  public @NotBlank(message = "Address is required") String getAddress() {
    return address;
  }

  public void setAddress(
      @NotBlank(message = "Address is required") String address) {
    this.address = address;
  }

  public @NotBlank(message = "Date of birth is required") String getDob() {
    return dob;
  }

  public void setDob(
      @NotBlank(message = "Date of birth is required") String dob) {
    this.dob = dob;
  }

  public String getRegDate() {
    return regDate;
  }

  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }

}
