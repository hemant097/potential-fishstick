package com.example.week3.week3Learning.DTO;

import java.time.LocalDateTime;

public record AppointmentDTO( Long id,
                              LocalDateTime appointmentTime,
                              String reason,
                              String patientEmail,
                              String doctorName) {

    public static AppointmentDTO of(
            Long id,
            LocalDateTime time,
            String reason,
            String patientEmail,
            String doctorName
    ) {
        return new AppointmentDTO(id, time, reason, patientEmail, doctorName);
    }
}
