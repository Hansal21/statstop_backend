package com.statstop.statstop.service;

import com.statstop.statstop.dto.FootBallGameDataDto;
import com.statstop.statstop.dto.GameDataDto;
import com.statstop.statstop.entity.FootBallGame;
import com.statstop.statstop.entity.FootBallTeam;
import com.statstop.statstop.entity.Game;
import com.statstop.statstop.entity.Team;
import com.statstop.statstop.repository.FootBallGameRepository;
import com.statstop.statstop.repository.FootBallTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

@RequiredArgsConstructor
public class FootBallServiceImpl implements FootBallService{
    private final FootBallTeamRepository footBallTeamRepository;
    private final FootBallGameRepository footBallGameRepository;

    @Override
    public FootBallTeam addTeam(FootBallTeam team) {
        log.info("football team "+team.getTeamName()+" added");

        return footBallTeamRepository.save(team);
    }

    @Override
    public FootBallGame addGame(FootBallGame game) {
        game.setTeam1Goals(0);
        game.setTeam2Goals(0);
        log.info("football game added");

        return footBallGameRepository.save(game);
    }

    @Override
    public Integer update(Integer gameId, Integer teamId) {
        FootBallGame game=footBallGameRepository.findByGameId(gameId);
        if(teamId==1){
            game.setTeam1Goals(game.getTeam1Goals()+1);
        }
        else{
            game.setTeam2Goals(game.getTeam2Goals()+1);
        }
        log.info("football game "+game.getGameId()+" updated");

        return footBallGameRepository.updateGame(game.getTeam1Goals(),game.getTeam2Goals(),game.getWinnerTeamId(),gameId);
    }

    @Override
    public List<FootBallTeam> getTeams() {
        return footBallTeamRepository.findAll();
    }

    @Override
    public List<FootBallGameDataDto> getGames() {
        List<FootBallGameDataDto> gameDataDtos=new ArrayList<>();
        List<Integer> gameIds=footBallGameRepository.findAllByOrderByGameIdDesc();
        for(Integer gameId:gameIds) {
            FootBallGame game = footBallGameRepository.findByGameId(gameId);
            FootBallTeam team1 = footBallTeamRepository.findByTeamId(game.getTeam1Id());
            FootBallTeam team2 = footBallTeamRepository.findByTeamId(game.getTeam2Id());
            FootBallTeam winner = footBallTeamRepository.findByTeamId(game.getWinnerTeamId());
            FootBallGameDataDto gameDataDto = FootBallGameDataDto.builder()
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
