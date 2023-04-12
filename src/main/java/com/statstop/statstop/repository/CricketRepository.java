package com.statstop.statstop.repository;

import com.statstop.statstop.entity.CricketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketRepository extends JpaRepository<CricketData, Integer> {
    CricketData findTopByOrderByIdDesc();
}
