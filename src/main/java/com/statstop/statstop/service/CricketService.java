package com.statstop.statstop.service;

import com.statstop.statstop.dto.UpdateDto;
import com.statstop.statstop.entity.CricketData;
import com.statstop.statstop.entity.Game;
import com.statstop.statstop.entity.Player;
import com.statstop.statstop.entity.Team;

import java.util.List;

public interface CricketService {
    Team addTeam(Team team);

    List<Player> addPlayer(List<Player> players);

    Game addGame(Game game);

    CricketData addCricketData(CricketData cricketData);

    Game getGameById(Integer gameId);

    Team getTeamById(Integer teamId);

    Player getPlayerbyId(Integer bowler);

    void addScoreCard(Integer gameId);

    Integer update(UpdateDto updateDto);
}
