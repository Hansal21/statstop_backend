package com.statstop.statstop.dto;

import com.statstop.statstop.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDataDto {
    private Integer gameId;
    private Team team1;
    private Integer team1Score;
    private Integer team1Wickets;
    private Team team2;
    private Integer team2Score;
    private Integer team2Wickets;
    private Team winnerTeam;
    private String remarks;
    private Integer team1overs;
    private Integer team2overs;
    private Integer team1ball;
    private Integer team2ball;
    private Integer totalOvers;
    private Integer firstInnings;
    private Date date;
    private String gameLevel;
}
