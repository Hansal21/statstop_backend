package com.statstop.statstop.repository;

import com.statstop.statstop.entity.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {
    public Game findByGameId(Integer gameId);

    @Modifying
    @Transactional
    @Query("update Game set team1Score=?1,team1Wickets=?2,team1ball=?3,team1overs=?4,team2Score=?5,team2Wickets=?6,team2ball=?7,team2overs=?8 where gameId=?9")
    Integer updateGame(Integer team1Score, Integer team1Wickets, Integer team1ball, Integer team1overs, Integer team2Score, Integer team2Wickets, Integer team2ball, Integer team2overs,Integer gameId);

    @Query("select g.gameId from Game g order by g.gameId desc")
    public List<Integer> findAllByOrderByGameIdDesc();
}
