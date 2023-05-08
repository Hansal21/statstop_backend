package com.statstop.statstop.service;

import com.statstop.statstop.dto.BasketBallGameDataDto;
import com.statstop.statstop.entity.BasketBallGame;
import com.statstop.statstop.entity.BasketBallTeam;
import com.statstop.statstop.entity.FootBallGame;
import com.statstop.statstop.entity.FootBallTeam;

import java.util.List;

public interface BasketBallService {
    BasketBallTeam addTeam(BasketBallTeam team);

    BasketBallGame addGame(BasketBallGame game);

    Integer update(Integer gameId, Integer teamId,Integer points);

    List<BasketBallTeam> getTeams();

    List<BasketBallGameDataDto> getGames();
}
