package com.statstop.statstop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class BasketBallGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private Integer team1Id;
    private Integer team1Goals;
    private Integer team2Id;
    private Integer team2Goals;
    private Integer winnerTeamId;
    private String remarks;
    private Date date;
    private String gameLevel;
}
