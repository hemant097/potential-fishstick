package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.DTO.AppointmentDTO;
import com.example.week3.week3Learning.Entity.Appointment;
import com.example.week3.week3Learning.Mappers.AppointmentMapper;
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
    private final AppointmentMapper appointmentMapper;

    AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper){
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;

    }


    @PostMapping("/create")
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestParam(name = "pid") Long patientId,
                                                            @RequestParam(name = "did") Long doctorId) {

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, Month.FEBRUARY,01, 15,15))
                .reason("stomach infection")
                .build();

        Appointment updatedAppointment = appointmentService.createNewAppointment(appointment,patientId,doctorId);

        AppointmentDTO appointmentDTO = appointmentMapper.toDto(updatedAppointment);
        return ResponseEntity.ok(appointmentDTO);


    }


}
