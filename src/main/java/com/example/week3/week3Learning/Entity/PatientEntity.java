package com.example.week3.week3Learning.Entity;

import com.example.week3.week3Learning.Entity.Type.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
        name = "patients",
        uniqueConstraints = {
                @UniqueConstraint(name="email_unique", columnNames = {"email"})
        }
)
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(name="dob")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    private String email;

    @CreationTimestamp
    private LocalDate createdAt;

    @OneToOne
//    @JoinColumn(name = "ins_id") //should use on owning side
    private Insurance insurance;  //owning side


    private Set<Appointment> appointmentSet = new HashSet<>();



}
