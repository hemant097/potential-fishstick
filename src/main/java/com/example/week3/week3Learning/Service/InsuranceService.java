package com.example.week3.week3Learning.Service;

import com.example.week3.week3Learning.Entity.Insurance;
import com.example.week3.week3Learning.Entity.PatientEntity;
import com.example.week3.week3Learning.Repository.InsuranceRepository;
import com.example.week3.week3Learning.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){

        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();

        //now insurance is in transient context, without CASCADE, will give TransientObjectException
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //optional, hibernate takes care of this itself, but may be useful in java object context

        return insurance;
    }

    @Transactional
    public PatientEntity removeInsuranceOfAPatient( Long patientId){

        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);

        return patient;
    }

}
