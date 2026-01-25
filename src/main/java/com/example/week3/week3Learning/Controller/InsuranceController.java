package com.example.week3.week3Learning.Controller;


import com.example.week3.week3Learning.Entity.Insurance;
import com.example.week3.week3Learning.Entity.PatientEntity;
import com.example.week3.week3Learning.Repository.PatientRepository;
import com.example.week3.week3Learning.Service.InsuranceService;
import com.example.week3.week3Learning.Service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    //Constructor injection
    InsuranceController( InsuranceService insuranceService) {
        this.insuranceService =  insuranceService;
    }

    @PostMapping("/add/{patientid}")
    public ResponseEntity<Insurance> addInsuranceToPatient(@PathVariable Long patientid) {
        List<String> companies = List.of("HDFC","AXIS","BHARTIAXA","MUTHOOT","EDELWEISS","IFFCO","ICICI","POLICYBAZAAR");

        int randomNumber = (int)(Math.random()*(8));

        int randomNumber2 = (int)(Math.random()*(10000-10))+10;

        String company = companies.get(randomNumber);

        Insurance insurance = Insurance.builder()
                .provider(company)
                .policyNumber(company+""+randomNumber2)
                .validUntil(LocalDate.of(2029,01,01))
                .build();
        Insurance updatedInsurance = insuranceService.assignInsuranceToPatient(insurance,patientid);

        return ResponseEntity.ok(updatedInsurance);

    }

    @DeleteMapping("/del/{patientId}")
    public ResponseEntity<PatientEntity> removeInsurance(@PathVariable Long patientId) {


        PatientEntity patient = insuranceService.removeInsuranceOfAPatient(patientId);

        return ResponseEntity.ok(patient);

    }
}
