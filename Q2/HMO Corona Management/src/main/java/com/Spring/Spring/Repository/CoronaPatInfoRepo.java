package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.CoronaPatInfo;
import com.Spring.Spring.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaPatInfoRepo extends JpaRepository<CoronaPatInfo, Long> {
}
