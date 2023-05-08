package com.statstop.statstop.dto;

import com.statstop.statstop.entity.ThrowBallTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThrowBallGameDataDto {
    private Integer gameId;
    private ThrowBallTeam team1;
    private Integer team1Goals;
    private ThrowBallTeam team2;
    private Integer team2Goals;
    private ThrowBallTeam winnerTeam;
    private String remarks;
    private Date date;
    private String gameLevel;
}
