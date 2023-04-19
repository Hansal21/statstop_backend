package com.statstop.statstop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private Integer team1Id;
    private Integer team1Score;
    private Integer team1Wickets;
    private Integer team2Id;
    private Integer team2Score;
    private Integer team2Wickets;
    private Integer winnerTeamId;
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
