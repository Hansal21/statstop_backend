package com.statstop.statstop.service;

import com.statstop.statstop.dto.ThrowBallGameDataDto;
import com.statstop.statstop.entity.ThrowBallGame;
import com.statstop.statstop.entity.ThrowBallTeam;

import java.util.List;

public interface ThrowBallService {
    ThrowBallTeam addTeam(ThrowBallTeam team);

    ThrowBallGame addGame(ThrowBallGame game);

    Integer update(Integer gameId, Integer teamId);

    List<ThrowBallTeam> getTeams();

    List<ThrowBallGameDataDto> getGames();
}
