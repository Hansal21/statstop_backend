package com.statstop.statstop.dto;

import com.statstop.statstop.entity.BasketBallTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketBallGameDataDto {
    private Integer gameId;
    private BasketBallTeam team1;
    private Integer team1Goals;
    private BasketBallTeam team2;
    private Integer team2Goals;
    private BasketBallTeam winnerTeam;
    private String remarks;
    private Date date;
    private String gameLevel;
}
