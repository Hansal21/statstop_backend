package com.statstop.statstop.service;

import com.statstop.statstop.dto.FootBallGameDataDto;
import com.statstop.statstop.entity.FootBallGame;
import com.statstop.statstop.entity.FootBallTeam;
import com.statstop.statstop.entity.Team;

import java.util.List;

public interface FootBallService {
    FootBallTeam addTeam(FootBallTeam team);

    FootBallGame addGame(FootBallGame game);

    Integer update(Integer gameId, Integer teamId);

    List<FootBallTeam> getTeams();

    List<FootBallGameDataDto> getGames();
}
