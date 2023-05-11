package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    /*@Query("SELECT p.id AS id,p.first_name as first_name,p.last_name as last_name,p.birth_date as birth_date," +
            "c.vac_date_1 as vac_date_1,c.vac_man_1 as vac_man_1, c.vac_date_2 as vac_date_2, c.vac_man_2 as vac_man_2, c.vac_date_3 as vac_date_3," +
            "c.vac_man_3 as vac_man_3, c.vac_date_4 as vac_date_4, c.vac_man_4 as vac_man_4,c.positive_date as positive_date, c.recovery_date as recovery_date " +
            "FROM Patient p JOIN CoronaPatInfo c ON p.id = c.id WHERE p.id = :id")
    List<Object[]> getPatientDetails(@Param("id") Long id);*/
    @Query("SELECT p,c FROM Patient p JOIN CoronaPatInfo c ON p.id = c.id WHERE p.id = :id")
    List<Object[]> getPatientDetails(@Param("id") Long id);
}
