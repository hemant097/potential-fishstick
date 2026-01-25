package com.example.week3.week3Learning.Repository;

import java.util.List;
import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {


    List<Doctor> findByExpertiseContaining(String expertise);

    @Query("select d from Doctor d left join fetch d.appointments")
    List<Doctor> getAllDoctors();
}