package com.example.week3.week3Learning.Repository;

import com.example.week3.week3Learning.Entity.Appointment;
import com.example.week3.week3Learning.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}