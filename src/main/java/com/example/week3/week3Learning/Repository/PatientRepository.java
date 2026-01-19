package com.example.week3.week3Learning.Repository;

import com.example.week3.week3Learning.DTO.IPatientInfo;
import com.example.week3.week3Learning.Entity.PatientEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {

    // use correct alias names ,Because Spring maps projection aliases using JavaBean property names,
    // not “case-insensitive words”. Thus, in alias as firstname won't work, as firstName will work, when interacting
    // with IPatientInfo methods (if any)
    @Query("Select p.id as id, p.email as email, p.firstName as firstName, p.lastName as lastName from PatientEntity p")
    List<IPatientInfo> getLimitedPatientInfo(Pageable pageable);
}
