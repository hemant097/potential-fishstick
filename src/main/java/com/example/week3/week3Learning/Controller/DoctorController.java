package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    DoctorService doctorService;

    DoctorController(DoctorService doctorService){
        this.doctorService=doctorService;
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteADoctorById(@PathVariable Long id){

        String str = doctorService.deleteADoctorById(id);
        return new ResponseEntity(str,HttpStatus.OK);


    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Doctor>> getAllDoctors(){

        List<Doctor> doctorList = doctorService.getAllDoctors();

        return ResponseEntity.ok(doctorList);
    }
}
