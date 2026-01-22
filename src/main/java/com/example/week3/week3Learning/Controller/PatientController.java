package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.DTO.BloodGroupStats;
import com.example.week3.week3Learning.DTO.CPatientInfo;
import com.example.week3.week3Learning.DTO.IPatientInfo;
import com.example.week3.week3Learning.Entity.Appointment;
import com.example.week3.week3Learning.Entity.Insurance;
import com.example.week3.week3Learning.Repository.PatientRepository;
import com.example.week3.week3Learning.Service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController  {

    private final PatientRepository patientRepository;
    private final PatientService patientService;

    //Constructor injection
    PatientController(PatientRepository patientRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }


    //inside-> custom Query, Transactional and Modifying Repository methods usage
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

        List<BloodGroupStats> patientEntityListDTOProjection2 = patientRepository.getLimitedPatientInfoUsingAggregateQuery();

        patientEntityListDTOProjection2.forEach((bg)->{
            System.out.println("blood group "+bg.bloodGroup()+" has count"+bg.count());
        });

        System.out.println(patientRepository.updatePatientNameWithId("Chamanbahar",15L));

        System.out.println(patientRepository.deletePatientWithId(14L));





    }



    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deletePatientAndAppointments(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
