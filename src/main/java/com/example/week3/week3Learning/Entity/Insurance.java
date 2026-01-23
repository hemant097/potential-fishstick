package com.example.week3.week3Learning.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 25)
    private String policyNumber;

    @Column(nullable = false, length = 50)
    private String provider;

    @Column(nullable = false)
    private LocalDate validUntil;

    @CreationTimestamp
    private LocalDate createdAt;

    @OneToOne(mappedBy = "insurance")
    @JsonIgnore
//    //as we do not want 2 sources of truth,
//    //insurance table shouldn't have patientId column, thus use mappedBy
    private PatientEntity patient; //inverse side, only this side should have mappedBy
}
