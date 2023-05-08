package com.statstop.statstop.dto;

import com.statstop.statstop.entity.FootBallTeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FootBallGameDataDto {
    private Integer gameId;
    private FootBallTeam team1;
    private Integer team1Goals;
    private FootBallTeam team2;
    private Integer team2Goals;
    private FootBallTeam winnerTeam;
    private String remarks;
    private Date date;
    private String gameLevel;
}
