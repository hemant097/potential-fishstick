package com.example.week3.week3Learning.Entity;

import com.example.week3.week3Learning.Entity.Type.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

    String firstName;

    String lastName;

    @Column(name="dob")
    LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    BloodGroup bloodGroup;

    String email;

    @CreationTimestamp
    LocalDate createdAt;

}
