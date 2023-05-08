package com.statstop.statstop.repository;

import com.statstop.statstop.entity.BasketBallTeam;
import com.statstop.statstop.entity.FootBallTeam;
import com.statstop.statstop.entity.ThrowBallTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThrowBallTeamRepository extends JpaRepository<ThrowBallTeam,Integer> {
    ThrowBallTeam findByTeamId(Integer teamId);
}
