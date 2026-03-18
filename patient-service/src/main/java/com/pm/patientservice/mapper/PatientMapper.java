package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import java.time.LocalDate;

public class PatientMapper {
  public static PatientResponseDTO toDTO(Patient patient) {
    PatientResponseDTO patientDTO = new PatientResponseDTO();
    patientDTO.setPatientId(patient.getPatientId().toString());
    patientDTO.setFullName(patient.getFullName());
    patientDTO.setAddress(patient.getAddress());
    patientDTO.setEmail(patient.getEmail());
    patientDTO.setDob(patient.getDob().toString());

    return patientDTO;
  }

  public static Patient toModel(PatientRequestDTO patientRequestDTO) {
    Patient patient = new Patient();
    patient.setFullName(patientRequestDTO.getFullName());
    patient.setAddress(patientRequestDTO.getAddress());
    patient.setEmail(patientRequestDTO.getEmail());
    patient.setDob(LocalDate.parse(patientRequestDTO.getDob()));
    patient.setRegDate(LocalDate.parse(patientRequestDTO.getRegDate()));
    return patient;
  }
}
