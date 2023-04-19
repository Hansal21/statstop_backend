package com.statstop.statstop.service;

import com.statstop.statstop.dto.UpdateDto;
import com.statstop.statstop.entity.*;
import com.statstop.statstop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CricketServiceImpl implements CricketService{
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    private final CricketRepository cricketRepository;

    private final ScoredRepository scoredRepository;

    @Override
    public Team addTeam(Team team) {
        Team team1=teamRepository.save(team);
        List<Player> players=team.getPlayers();
        for(Player p:players){
            p.setTeam(team1);
        }
        addPlayer(players);
        return team1;
    }
    @Override
    public List<Player> addPlayer(List<Player> players) {
        return playerRepository.saveAll(players);
    }

    @Override
    public Game addGame(Game game) {
        game.setTeam1Score(0);
        game.setTeam2Score(0);
        game.setTeam1Wickets(0);
        game.setTeam2Wickets(0);
        game.setTeam1overs(0);
        game.setTeam2overs(0);
        game.setTeam1ball(0);
        game.setTeam2ball(0);
        game.setFirstInnings(1);
        return gameRepository.save(game);
    }

    @Override
    public CricketData addCricketData(CricketData cricketData) {
        return cricketRepository.save(cricketData);
    }

    @Override
    public Game getGameById(Integer gameId) {
        return gameRepository.findByGameId(gameId);
    }

    @Override
    public Team getTeamById(Integer teamId) {
        return teamRepository.findByTeamId(teamId);
    }

    @Override
    public Player getPlayerbyId(Integer playerId) {
        return playerRepository.findByPlayerId(playerId);
    }

    @Override
    public void addScoreCard(Integer gameId) {
        List<ScoreCard> scoreCards=new ArrayList<>();
//        ScoreCard scoreCard=ScoreCard.builder()
//                .gameId(gameId)
//                .ball(0)
//                .run(0)
//                .fours(0)
//                .sixes(0)
//                .strikeRate(0.0)
//                .status("did not bat")
//                .build();
        Integer team1Id=gameRepository.findByGameId(gameId).getTeam1Id();
        Integer team2Id=gameRepository.findByGameId(gameId).getTeam2Id();
        Team team1=teamRepository.findByTeamId(team1Id);
        Team team2=teamRepository.findByTeamId(team2Id);
        for(Player p: team1.getPlayers()){
            ScoreCard scoreCard=new ScoreCard(gameId,"Did not bat",0,0,0,0,0.0);
            scoreCard.setTeamId(team1Id);
            scoreCard.setPlayerId(p.getPlayerId());
            scoreCards.add(scoreCard);
        }
        for(Player p: team2.getPlayers()){
            ScoreCard scoreCard=new ScoreCard(gameId,"Did not bat",0,0,0,0,0.0);
            scoreCard.setTeamId(team2Id);
            scoreCard.setPlayerId(p.getPlayerId());
            scoreCards.add(scoreCard);
        }
        scoredRepository.saveAll(scoreCards);
    }

    @Override
    public Integer update(UpdateDto updateDto) {
        Game game=gameRepository.findByGameId(updateDto.getGameId());
        if(updateDto.getFirstInnings()==1){
         game.setTeam1Score(game.getTeam1Score()+updateDto.getRunScored());
         game.setTeam1Wickets(game.getTeam1Wickets()+updateDto.getWicket());
         game.setTeam1ball((game.getTeam1ball()==6?1: game.getTeam1ball()+1));
         game.setTeam1overs(game.getTeam1ball()==1? game.getTeam1overs() +1: game.getTeam1overs());
        }
        else{
            game.setTeam2Score(game.getTeam2Score()+updateDto.getRunScored());
            game.setTeam2Wickets(game.getTeam2Wickets()+updateDto.getWicket());
            game.setTeam2ball((game.getTeam2ball()==6?1: game.getTeam2ball()+1));
            game.setTeam2overs(game.getTeam2ball()==1? game.getTeam2overs() +1: game.getTeam2overs());
        }
        return gameRepository.updateGame(game.getTeam1Score(),game.getTeam1Wickets(),game.getTeam1ball(),game.getTeam1overs(),
                game.getTeam2Score(),game.getTeam2Wickets(),game.getTeam2ball(),game.getTeam2overs(), updateDto.getGameId());
    }
}
