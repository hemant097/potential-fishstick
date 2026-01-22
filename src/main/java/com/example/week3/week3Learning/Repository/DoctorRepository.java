package com.example.week3.week3Learning.Repository;

import java.util.List;
import com.example.week3.week3Learning.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {


    List<Doctor> findByExpertiseContaining(String expertise);
}