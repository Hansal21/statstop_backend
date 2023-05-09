package com.statstop.statstop.service;

import com.statstop.statstop.dto.ThrowBallGameDataDto;
import com.statstop.statstop.entity.ThrowBallGame;
import com.statstop.statstop.entity.ThrowBallTeam;
import com.statstop.statstop.entity.ThrowBallGame;
import com.statstop.statstop.entity.ThrowBallTeam;
import com.statstop.statstop.repository.ThrowBallGameRepository;
import com.statstop.statstop.repository.ThrowBallTeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ThrowBallServiceImpl implements ThrowBallService{
    private final ThrowBallTeamRepository throwBallTeamRepository;
    private final ThrowBallGameRepository throwBallGameRepository;

    @Override
    public ThrowBallTeam addTeam(ThrowBallTeam team) {
        log.info("throwball team "+team.getTeamName()+" added");

        return throwBallTeamRepository.save(team);

    }

    @Override
    public ThrowBallGame addGame(ThrowBallGame game) {
        game.setTeam1Goals(0);
        game.setTeam2Goals(0);
        log.info("throwball game added");

        return throwBallGameRepository.save(game);
    }

    @Override
    public Integer update(Integer gameId, Integer teamId) {
        ThrowBallGame game=throwBallGameRepository.findByGameId(gameId);
        if(teamId==1){
            game.setTeam1Goals(game.getTeam1Goals()+1);
        }
        else{
            game.setTeam2Goals(game.getTeam2Goals()+1);

        }
        log.info("throwball game "+game.getGameId()+" updated");


        return throwBallGameRepository.updateGame(game.getTeam1Goals(),game.getTeam2Goals(),game.getWinnerTeamId(),gameId);
    }

    @Override
    public List<ThrowBallTeam> getTeams() {
        return throwBallTeamRepository.findAll();
    }

    @Override
    public List<ThrowBallGameDataDto> getGames() {
        List<ThrowBallGameDataDto> gameDataDtos=new ArrayList<>();
        List<Integer> gameIds=throwBallGameRepository.findAllByOrderByGameIdDesc();
        for(Integer gameId:gameIds) {
            ThrowBallGame game = throwBallGameRepository.findByGameId(gameId);
            ThrowBallTeam team1 = throwBallTeamRepository.findByTeamId(game.getTeam1Id());
            ThrowBallTeam team2 = throwBallTeamRepository.findByTeamId(game.getTeam2Id());
            ThrowBallTeam winner = throwBallTeamRepository.findByTeamId(game.getWinnerTeamId());
            ThrowBallGameDataDto gameDataDto = ThrowBallGameDataDto.builder()
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
