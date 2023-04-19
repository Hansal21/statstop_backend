package com.statstop.statstop.repository;

import com.statstop.statstop.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {
    Team findByTeamId(Integer teamId);
}
