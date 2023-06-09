package com.statstop.statstop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CricketData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer ballNo;
    private Integer overNo;
    private Integer gameId;
    private Integer teamId;
    private Integer bowler;
    private Integer batter1;
    private Integer batter1Run;
    private Integer batter2;
    private Integer batter2Run;
    private Integer wicket;
    private Integer runScoredThisBall;
    private Integer totalScore;
    private Integer totalWickets;
}
