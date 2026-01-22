package com.example.week3.week3Learning.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false, unique = true) //every department must've a head doctor
    private Doctor headDoctor;

    @ManyToMany
    @Builder.Default
    private Set<Doctor> doctors = new HashSet<>();



}
