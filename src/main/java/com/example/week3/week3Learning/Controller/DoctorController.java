package com.example.week3.week3Learning.Controller;

import com.example.week3.week3Learning.Service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
