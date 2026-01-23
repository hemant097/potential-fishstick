package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.DTO.DepartmentDTO;
import com.example.week3.week3Learning.Entity.Department;
import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Mappers.DepartmentMapper;
import com.example.week3.week3Learning.Service.DepartmentService;
import com.example.week3.week3Learning.Service.DoctorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DoctorService doctorService;
    private final DepartmentMapper departmentMapper;

    DepartmentController(DepartmentService departmentService, DoctorService doctorService,DepartmentMapper departmentMapper){
        this.departmentService = departmentService;
        this.doctorService = doctorService;
        this.departmentMapper = departmentMapper;
    }

    @PostMapping(path = "/create/{headDoctorId}")
    public ResponseEntity<DepartmentDTO> createDepartment(@PathVariable Long headDoctorId) {

        Doctor headDoctor = doctorService.findDoctorById(headDoctorId);

        Department newDepartment = departmentService.makeNewDepartment(headDoctor);

        //Builder.Default in Department can prevent this
        System.out.println("checking "+newDepartment.getDoctors());

        List<Doctor> doctorListToAdd = doctorService.findDoctorsByExpertise("neuro");

        Department updatedDepartment = departmentService.addDoctors(doctorListToAdd, newDepartment.getId());

        DepartmentDTO departmentDTO = departmentMapper.toDTO(updatedDepartment);
        return ResponseEntity.ok(departmentDTO);
//        System.out.println(updatedDepartment.getName()+" has head doctor "+updatedDepartment.getHeadDoctor().getName()+" with department list below");
//
//        updatedDepartment.getDoctors().forEach(d-> System.out.println(d.getEmail()+", "+d.getExpertise()));


    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
