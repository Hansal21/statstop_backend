package com.statstop.statstop.controller;

import com.statstop.statstop.dto.CricketDataDto;
import com.statstop.statstop.dto.GameDataDto;
import com.statstop.statstop.dto.LoginDto;
import com.statstop.statstop.dto.UpdateDto;
import com.statstop.statstop.entity.*;
import com.statstop.statstop.repository.CricketRepository;
import com.statstop.statstop.repository.UserRepository;
import com.statstop.statstop.service.CricketService;
import com.statstop.statstop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CricketScoreController {
    @Autowired
    private CricketRepository cricketRepository;

    private final CricketService cricketService;

    @PostMapping("add-scorecard")
    public void addScoreCard(@RequestParam("gameId") Integer gameId){
        cricketService.addScoreCard(gameId);
    }

    @GetMapping(value="live-score")
    public CricketDataDto getScorecard(){
        CricketData cricketData=cricketRepository.findTopByOrderByIdDesc();
        Team team=cricketService.getTeamById(cricketData.getTeamId());
        team.setPlayers(null);
        CricketDataDto cricketDataDto=CricketDataDto.builder()
                .ballNo(cricketData.getBallNo())
                .overNo(cricketData.getOverNo())
                .gameId(cricketService.getGameById(cricketData.getGameId()))
                .teamId(team)
                .bowler(cricketService.getPlayerbyId(cricketData.getBowler()))
                .batter1(cricketService.getPlayerbyId(cricketData.getBatter1()))
                .batter2(cricketService.getPlayerbyId(cricketData.getBatter2()))
                .batter1Run(cricketData.getBatter1Run())
                .batter2Run(cricketData.getBatter2Run())
                .runScoredThisBall(cricketData.getRunScoredThisBall())
                .totalScore(cricketData.getTotalScore())
                .totalWickets(cricketData.getTotalWickets())
                .wicket(cricketData.getWicket())
                .build();

        return cricketDataDto;
    }

    @PostMapping("add-team")
    public Team addTeam(@RequestBody Team team){
        return cricketService.addTeam(team);
    }

    @PostMapping("add-player")
    public List<Player> addPlayer(@RequestBody List<Player> players){
        return cricketService.addPlayer(players);
    }

    @PostMapping("add-game")
    public Game addgame(@RequestBody Game game){
        System.out.println(game);
        return cricketService.addGame(game);
    }

    @PostMapping("update")
    public Integer update(@RequestBody UpdateDto updateDto){
        return cricketService.update(updateDto);
    }
    @PostMapping("add-score")
    public CricketData addCricketData(@RequestBody CricketData cricketData){
        return cricketService.addCricketData(cricketData);
    }
    @GetMapping("get-games")
    public List<GameDataDto> getGame(){
        List<GameDataDto> gameDataDtos=new ArrayList<>();
        List<Integer> gameIds=cricketService.getAllGames();
        for(Integer gameId:gameIds) {
            Game game = cricketService.getGameById(gameId);
            Team team1 = cricketService.getTeamById(game.getTeam1Id());
            Team team2 = cricketService.getTeamById(game.getTeam2Id());
            Team winner = cricketService.getTeamById(game.getWinnerTeamId());
            team1.setPlayers(null);
            team2.setPlayers(null);
            if (winner != null)
                winner.setPlayers(null);
            GameDataDto gameDataDto = GameDataDto.builder()
                    .gameId(game.getGameId())
                    .team1(team1)
                    .team2(team2)
                    .team2Score(game.getTeam2Score())
                    .team1Score(game.getTeam1Score())
                    .remarks(game.getRemarks())
                    .winnerTeam(winner)
                    .team1overs(game.getTeam1overs())
                    .team1ball(game.getTeam1ball())
                    .team2overs(game.getTeam2overs())
                    .team2ball(game.getTeam2ball())
                    .totalOvers(game.getTotalOvers())
                    .firstInnings(game.getFirstInnings())
                    .date(game.getDate())
                    .team1Wickets(game.getTeam1Wickets())
                    .team2Wickets(game.getTeam2Wickets())
                    .gameLevel(game.getGameLevel())
                    .build();
            gameDataDtos.add(gameDataDto);
        }
        return gameDataDtos;
    }

    private final UserService userService;
    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
