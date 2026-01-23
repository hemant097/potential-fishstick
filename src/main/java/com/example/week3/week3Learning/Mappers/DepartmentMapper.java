package com.example.week3.week3Learning.Mappers;

import com.example.week3.week3Learning.DTO.DepartmentDTO;
import com.example.week3.week3Learning.Entity.Department;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {

    public DepartmentDTO toDTO(Department dept){

        Set<String> doctorNames = dept.getDoctors()
                                        .stream()
                                        .map(doct->doct.getName())
                                        .collect(Collectors.toSet());

        return DepartmentDTO.of(dept.getId(),
                                dept.getName(),
                                dept.getHeadDoctor().getName(),
                                doctorNames
        );
    }
}
