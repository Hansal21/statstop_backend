package com.statstop.statstop.repository;

import com.statstop.statstop.entity.ScoreCard;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ScoredRepository extends JpaRepository<ScoreCard,Integer> {


}
