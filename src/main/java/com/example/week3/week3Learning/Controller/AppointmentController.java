package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Entity.Appointment;
import com.example.week3.week3Learning.Service.AppointmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;

@RestController
public class AppointmentController implements CommandLineRunner {

    private final AppointmentService appointmentService;

    AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @Override
    public void run(String... args) throws Exception {

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, Month.FEBRUARY,01, 15,15))
                .name("stomach infection")
                .build();

        Appointment updatedAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(updatedAppointment.getDoctor().getName()+ " is the doctor for "+updatedAppointment.getPatient().getEmail());

    }
}
