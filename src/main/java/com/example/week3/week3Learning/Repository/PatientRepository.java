package com.example.week3.week3Learning.Repository;

import com.example.week3.week3Learning.DTO.BloodGroupStats;
import com.example.week3.week3Learning.DTO.CPatientInfo;
import com.example.week3.week3Learning.DTO.IPatientInfo;
import com.example.week3.week3Learning.Entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity,Long> {

    // use correct alias names ,Because Spring maps projection aliases using JavaBean property names,
    // not “case-insensitive words”. Thus, in alias as firstname won't work, as firstName will work, when interacting
    // with IPatientInfo methods (if any)
    @Query("Select p.id as id, p.email as email, p.firstName as firstName, p.lastName as lastName from PatientEntity p")
    List<IPatientInfo> getLimitedPatientInfo(Pageable pageable);

    @Query("Select new com.example.week3.week3Learning.DTO.CPatientInfo(p.id,p.firstName) from PatientEntity p")
    List<CPatientInfo> getLimitedPatientInfo2(Pageable pageable);

    @Query("Select new com.example.week3.week3Learning.DTO.BloodGroupStats(p.bloodGroup,count(p)) " +
            "from PatientEntity p group by p.bloodGroup order by count(p) desc, p.bloodGroup asc")
    List<BloodGroupStats> getLimitedPatientInfoUsingAggregateQuery();

    @Transactional
    @Modifying // Modifying queries can only use void, int/Integer, or long as return type
    @Query("Update PatientEntity p set p.firstName=:name where p.id=:id")
    int updatePatientNameWithId(@Param("name") String nameToUpdate, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE from PatientEntity p where p.id=:id")
    int deletePatientWithId( @Param("id") Long id);

}
