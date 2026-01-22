package com.example.week3.week3Learning.Service;

import com.example.week3.week3Learning.Entity.Appointment;
import com.example.week3.week3Learning.Entity.Doctor;
import com.example.week3.week3Learning.Entity.PatientEntity;
import com.example.week3.week3Learning.Repository.AppointmentRepository;
import com.example.week3.week3Learning.Repository.DoctorRepository;
import com.example.week3.week3Learning.Repository.InsuranceRepository;
import com.example.week3.week3Learning.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional//either commit all the changes else rollback
    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId){
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        //appointment is still in transient state till here,

        appointmentRepository.save(appointment);

        //now appointment has been changed to persistent state,
        return appointment;

    }
}
