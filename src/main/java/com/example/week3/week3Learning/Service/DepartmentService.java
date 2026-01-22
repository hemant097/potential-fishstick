package com.example.week3.week3Learning.Service;

import com.example.week3.week3Learning.Entity.Department;
import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Repository.DepartmentRepository;
import com.example.week3.week3Learning.Repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Department makeNewDepartment(Doctor headDoctor){
        //as we cannot create a new department without a head doctor
        Department department = Department.builder()
                .headDoctor(headDoctor)
                .name("Neurology")
                .build();

        return departmentRepository.save(department);

    }

    @Transactional
    public Department addDoctors(List<Doctor> doctorList, Long departmentId){
        Department department = departmentRepository.findById(departmentId).orElseThrow();

        //BAD practice to replace the collection, will perform delete queries
//        Set<Doctor> doctorSet = new HashSet<>(doctorList);
//        department.setDoctors(doctorSet);
        department.getDoctors().addAll(doctorList);

        departmentRepository.save(department);

        return department;
    }
}
