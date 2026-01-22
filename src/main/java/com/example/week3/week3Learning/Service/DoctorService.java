package com.example.week3.week3Learning.Service;

import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor findDoctorById(Long doctorId){

        return doctorRepository.findById(doctorId).orElseThrow();
    }

    public List<Doctor> findDoctorsByExpertise(String expertise){

       return doctorRepository.findByExpertiseContaining(expertise);
    }
}
