package com.statstop.statstop.service;

import com.statstop.statstop.dto.BasketBallGameDataDto;
import com.statstop.statstop.entity.BasketBallGame;
import com.statstop.statstop.entity.BasketBallTeam;
import com.statstop.statstop.entity.BasketBallGame;
import com.statstop.statstop.entity.BasketBallTeam;
import com.statstop.statstop.repository.BasketBallGameRepository;
import com.statstop.statstop.repository.BasketBallTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketBallServiceImpl implements BasketBallService{
    private final BasketBallTeamRepository basketBallTeamRepository;
    private final BasketBallGameRepository basketBallGameRepository;

    @Override
    public BasketBallTeam addTeam(BasketBallTeam team) {
        return basketBallTeamRepository.save(team);
    }

    @Override
    public BasketBallGame addGame(BasketBallGame game) {
        game.setTeam1Goals(0);
        game.setTeam2Goals(0);
        return basketBallGameRepository.save(game);
    }

    @Override
    public Integer update(Integer gameId, Integer teamId,Integer points) {
        BasketBallGame game=basketBallGameRepository.findByGameId(gameId);
        if(teamId==1){
            game.setTeam1Goals(game.getTeam1Goals()+points);
        }
        else{
            game.setTeam2Goals(game.getTeam2Goals()+points);
        }
        return basketBallGameRepository.updateGame(game.getTeam1Goals(),game.getTeam2Goals(),game.getWinnerTeamId(),gameId);
    }

    @Override
    public List<BasketBallTeam> getTeams() {
        return basketBallTeamRepository.findAll();
    }

    @Override
    public List<BasketBallGameDataDto> getGames() {
        List<BasketBallGameDataDto> gameDataDtos=new ArrayList<>();
        List<Integer> gameIds=basketBallGameRepository.findAllByOrderByGameIdDesc();
        for(Integer gameId:gameIds) {
            BasketBallGame game = basketBallGameRepository.findByGameId(gameId);
            BasketBallTeam team1 = basketBallTeamRepository.findByTeamId(game.getTeam1Id());
            BasketBallTeam team2 = basketBallTeamRepository.findByTeamId(game.getTeam2Id());
            BasketBallTeam winner = basketBallTeamRepository.findByTeamId(game.getWinnerTeamId());
            BasketBallGameDataDto gameDataDto = BasketBallGameDataDto.builder()
                    .gameId(game.getGameId())
                    .team1(team1)
                    .team2(team2)
                    .team1Goals(game.getTeam1Goals())
                    .team2Goals(game.getTeam2Goals())
                    .remarks(game.getRemarks())
                    .winnerTeam(winner)
                    .date(game.getDate())
                    .gameLevel(game.getGameLevel())
                    .build();
            gameDataDtos.add(gameDataDto);
        }
        return gameDataDtos;
    }
}


