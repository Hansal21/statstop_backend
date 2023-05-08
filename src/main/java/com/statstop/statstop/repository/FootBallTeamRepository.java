package com.statstop.statstop.repository;

import com.statstop.statstop.entity.FootBallTeam;
import com.statstop.statstop.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootBallTeamRepository extends JpaRepository<FootBallTeam,Integer> {
    FootBallTeam findByTeamId(Integer teamId);
}
