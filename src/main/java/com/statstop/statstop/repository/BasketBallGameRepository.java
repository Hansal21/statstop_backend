package com.statstop.statstop.repository;

import com.statstop.statstop.entity.BasketBallGame;
import com.statstop.statstop.entity.FootBallGame;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasketBallGameRepository extends JpaRepository<BasketBallGame,Integer> {
    public BasketBallGame findByGameId(Integer gameId);

    @Query("select g.gameId from BasketBallGame g order by g.gameId desc")
    public List<Integer> findAllByOrderByGameIdDesc();
    @Modifying
    @Transactional
    @Query("update BasketBallGame set team1Goals=?1,team2Goals=?2,winnerTeamId=?3 where gameId=?4")
    Integer updateGame(Integer team1Goals, Integer team2Goals, Integer winnerTeamId, Integer gameId);
}
