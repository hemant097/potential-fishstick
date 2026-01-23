package com.example.week3.week3Learning.Mappers;

import com.example.week3.week3Learning.DTO.AppointmentDTO;
import com.example.week3.week3Learning.Entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDto(Appointment appointment) {
        return  AppointmentDTO.of(appointment.getId(),
                appointment.getAppointmentTime(),
                appointment.getReason(),
                appointment.getPatient().getEmail(),
                appointment.getDoctor().getName());
    }
}
