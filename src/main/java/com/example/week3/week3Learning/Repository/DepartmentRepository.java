package com.example.week3.week3Learning.Repository;

import com.example.week3.week3Learning.Entity.Department;
import com.example.week3.week3Learning.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    List<Department> findAllByDoctorsContaining(Doctor doctor);

    boolean existsByHeadDoctor(Doctor doctor);
}
