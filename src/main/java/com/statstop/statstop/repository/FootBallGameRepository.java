package com.statstop.statstop.repository;

import com.statstop.statstop.entity.FootBallGame;
import com.statstop.statstop.entity.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FootBallGameRepository extends JpaRepository<FootBallGame,Integer> {
    public FootBallGame findByGameId(Integer gameId);

    @Query("select g.gameId from FootBallGame g order by g.gameId desc")
    public List<Integer> findAllByOrderByGameIdDesc();

    @Modifying
    @Transactional
    @Query("update FootBallGame set team1Goals=?1,team2Goals=?2,winnerTeamId=?3 where gameId=?4")
    Integer updateGame(Integer team1Goals, Integer team2Goals, Integer winnerTeamId, Integer gameId);
}
