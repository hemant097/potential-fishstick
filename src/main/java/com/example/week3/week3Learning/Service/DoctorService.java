package com.example.week3.week3Learning.Service;

import com.example.week3.week3Learning.Entity.Department;
import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Repository.DepartmentRepository;
import com.example.week3.week3Learning.Repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;

    public Doctor findDoctorById(Long doctorId){
        return doctorRepository.findById(doctorId).orElseThrow();
    }


    public List<Doctor> findDoctorsByExpertise(String expertise){
       return doctorRepository.findByExpertiseContaining(expertise);
    }

    @Transactional
    public String deleteADoctorById(Long id){
        //1. Load the Doctor entity
        Doctor doctor = doctorRepository.findById(id).orElseThrow();

        List<Department> departments =
                departmentRepository.findAllByDoctorsContaining(doctor);

        //2. Remove doctor from all departments (Many-to-Many)
        departments.forEach(d -> d.getDoctors().remove(doctor));

        //3. Handle headDoctor constraint
        if (departmentRepository.existsByHeadDoctor(doctor)) {
            throw new IllegalStateException(
                    "This Doctor is head of a department"
            );
        }
        //4. Delete the doctor
        doctorRepository.delete(doctor);
        return "successfully deleted";
    }
}
