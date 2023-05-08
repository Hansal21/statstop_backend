package com.statstop.statstop.repository;

import com.statstop.statstop.entity.BasketBallTeam;
import com.statstop.statstop.entity.FootBallTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketBallTeamRepository extends JpaRepository<BasketBallTeam,Integer> {
    BasketBallTeam findByTeamId(Integer teamId);

}
