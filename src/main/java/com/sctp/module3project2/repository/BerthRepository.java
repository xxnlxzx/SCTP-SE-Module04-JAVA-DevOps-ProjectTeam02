package com.sctp.module3project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;
import com.sctp.module3project2.entity.Berth;

// @Repository
public interface BerthRepository extends JpaRepository<Berth, Long> {

    Berth findBerthPortLocationById(Long id);

    @Query(value = "ALTER SEQUENCE berth_id_seq RESTART WITH 1", nativeQuery = true)
    void resetIdSequence();
}