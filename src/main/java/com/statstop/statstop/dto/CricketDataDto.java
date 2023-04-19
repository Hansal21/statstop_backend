package com.statstop.statstop.dto;

import com.statstop.statstop.entity.Game;
import com.statstop.statstop.entity.Player;
import com.statstop.statstop.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CricketDataDto {
    private Integer id;
    private Integer ballNo;
    private Integer overNo;
    private Game gameId;
    private Team teamId;
    private Player bowler;
    private Player batter1;
    private Integer batter1Run;
    private Player batter2;
    private Integer batter2Run;
    private Integer wicket;
    private Integer runScoredThisBall;
    private Integer totalScore;
    private Integer totalWickets;
}
