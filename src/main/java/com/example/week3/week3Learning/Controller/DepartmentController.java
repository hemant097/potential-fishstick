package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Entity.Department;
import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Service.DepartmentService;
import com.example.week3.week3Learning.Service.DoctorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController
public class DepartmentController implements CommandLineRunner {

    private final DepartmentService departmentService;
    private final DoctorService doctorService;

    DepartmentController(DepartmentService departmentService, DoctorService doctorService){
        this.departmentService = departmentService;
        this.doctorService = doctorService;
    }

    @Override
    public void run(String... args) throws Exception {

        Doctor headDoctor = doctorService.findDoctorById(2L);

        Department department = departmentService.makeNewDepartment(headDoctor);

        //Builder.Default in Department can prevent this
        System.out.println("checking "+department.getDoctors());

        List<Doctor> doctorListToAdd = doctorService.findDoctorsByExpertise("neuro");

        Department updatedDepartment = departmentService.addDoctors(doctorListToAdd, department.getId());

        System.out.println(updatedDepartment.getName()+" has head doctor "+updatedDepartment.getHeadDoctor().getName()+" with department list below");

        updatedDepartment.getDoctors().forEach(d-> System.out.println(d.getEmail()+", "+d.getExpertise()));


    }
}
