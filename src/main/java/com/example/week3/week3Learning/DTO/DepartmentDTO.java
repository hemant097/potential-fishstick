package com.example.week3.week3Learning.DTO;

import java.util.Set;

public record DepartmentDTO(Long id,String name, String headDoctorName, Set<String> doctorNames) {


    public static DepartmentDTO of(
            Long id, String name, String headDoctorName, Set<String> doctorNames) {

        return new DepartmentDTO(id,name,headDoctorName,doctorNames);

    }

}
