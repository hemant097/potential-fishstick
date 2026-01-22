package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Entity.Appointment;
import com.example.week3.week3Learning.Service.AppointmentService;
import com.example.week3.week3Learning.Service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;

@RestController
@RequestMapping("/appointment")
public class AppointmentController  {

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    AppointmentController(AppointmentService appointmentService,  PatientService patientService){
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createAppointment() {

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, Month.FEBRUARY,01, 15,15))
                .name("stomach infection")
                .build();

        Appointment updatedAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        return ResponseEntity.ok(updatedAppointment.getDoctor().getName()+ " is the doctor for "+updatedAppointment.getPatient().getEmail());


    }


}
