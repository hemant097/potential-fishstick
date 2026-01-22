package com.example.week3.week3Learning.Controller;


import com.example.week3.week3Learning.Entity.Insurance;
import com.example.week3.week3Learning.Repository.PatientRepository;
import com.example.week3.week3Learning.Service.InsuranceService;
import com.example.week3.week3Learning.Service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class InsuranceController {

    private final InsuranceService insuranceService;

    //Constructor injection
    InsuranceController( InsuranceService insuranceService) {
        this.insuranceService =  insuranceService;
    }

//    @Override
    public void run(String... args) throws Exception {
        System.out.println("in insurance controller cmd line runer");
//        Insurance insurance = Insurance.builder()
//                .provider("HDFC")
//                .policyNumber("HDFC2345")
//                .validUntil(LocalDate.of(2029,01,01))
//                .build();
//        Insurance updatedInsurance = insuranceService.assignInsuranceToPatient(insurance,1L);
//
//  System.out.println(   updatedInsurance.getPatient().getEmail()+" "+updatedInsurance.getProvider()+" "+updatedInsurance.getValidUntil());

    }
}
