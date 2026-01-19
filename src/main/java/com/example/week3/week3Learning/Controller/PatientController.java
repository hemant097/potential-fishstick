package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.DTO.IPatientInfo;
import com.example.week3.week3Learning.Entity.PatientEntity;
import com.example.week3.week3Learning.Entity.Type.BloodGroup;
import com.example.week3.week3Learning.Repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController implements CommandLineRunner {

    private final PatientRepository patientRepository;

    PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        List<IPatientInfo> patientEntityList = patientRepository.getLimitedPatientInfo(PageRequest.of(0,5));

        patientEntityList.forEach(patient->{
            System.out.println("\n"+patient);
            System.out.println("patient's full name is "+patient.getFirstName()+" "+patient.getLastName()+
                    " and email is "+patient.getEmail());
        });

    }
}
