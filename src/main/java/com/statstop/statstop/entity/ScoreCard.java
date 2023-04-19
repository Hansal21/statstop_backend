package com.statstop.statstop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer gameId;
    private Integer teamId;
    private Integer playerId;
    private String status;
    private Integer run;
    private Integer ball;
    private Integer fours;
    private Integer sixes;
    private Double strikeRate;

    public ScoreCard(Integer gameId, String status, Integer run, Integer ball, Integer fours, Integer sixes, Double strikeRate) {
        this.gameId = gameId;
        this.status = status;
        this.run = run;
        this.ball = ball;
        this.fours = fours;
        this.sixes = sixes;
        this.strikeRate = strikeRate;
    }
}
