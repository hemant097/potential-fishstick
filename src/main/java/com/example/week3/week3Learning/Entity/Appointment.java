package com.example.week3.week3Learning.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String name;

    @ManyToOne // read this relationship like many appointment to one patient
    @JoinColumn(name = "patient_id",
            nullable = false)
    //owning side should have JoinColumn
    private PatientEntity patient;
    //owning side in this relationship


    @ManyToOne
    @JoinColumn(name = "doctor_id",
            nullable = false)
    private Doctor doctor;


}
