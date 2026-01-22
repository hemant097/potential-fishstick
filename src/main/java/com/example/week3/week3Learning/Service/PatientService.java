package com.example.week3.week3Learning.Service;

import com.example.week3.week3Learning.Entity.PatientEntity;
import com.example.week3.week3Learning.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){

        PatientEntity p1 = patientRepository.findById(1L).orElseThrow();
        PatientEntity p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1==p2);
        System.out.println(p1.getEmail()+", "+p2.getEmail());

        p1.setEmail("donBahadur@gmail.com");
        System.out.println(p1.getEmail());

        PatientEntity p3 = patientRepository.findById(1L).orElseThrow();
        System.out.println(p3.getEmail());
    }


    public void deletePatient(Long patientId){
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);

    }


}
