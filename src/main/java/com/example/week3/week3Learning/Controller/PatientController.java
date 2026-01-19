package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.DTO.BloodGroupStats;
import com.example.week3.week3Learning.DTO.CPatientInfo;
import com.example.week3.week3Learning.DTO.IPatientInfo;
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

        List<IPatientInfo> patientEntityListInterfaceProjection = patientRepository.getLimitedPatientInfo(PageRequest.of(0,5));

        patientEntityListInterfaceProjection.forEach(patient->{
            System.out.println("\n"+patient);
            System.out.println("patient's full name is "+patient.getFirstName()+" "+patient.getLastName()+
                    " and email is "+patient.getEmail());
        });

        List<CPatientInfo> patientEntityListDTOProjection = patientRepository.getLimitedPatientInfo2(PageRequest.of(0,5));

        patientEntityListDTOProjection.forEach((patient)->{
            System.out.println(patient);
            System.out.println("patient's first name is "+patient.firstName());
        });

        List<BloodGroupStats> patientEntityListDTOProjection2 = patientRepository.getLimitedPatientInfoUsingAggregrateQuery();

        patientEntityListDTOProjection2.forEach((bg)->{
            System.out.println(bg);
        });

    }
}
