package com.example.week3.week3Learning.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
        name = "doctors", uniqueConstraints = {
                @UniqueConstraint(name="email_unique", columnNames = {"email"})
        }
)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 100)
    private String expertise;

    @Column(nullable = false, length =30)
    private String email;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();
}
