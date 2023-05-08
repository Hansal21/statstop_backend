package com.statstop.statstop.controller;

import com.statstop.statstop.dto.UpdateDto;
import com.statstop.statstop.entity.FootBallGame;
import com.statstop.statstop.entity.FootBallTeam;
import com.statstop.statstop.entity.Game;
import com.statstop.statstop.entity.Team;
import com.statstop.statstop.service.FootBallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("football")
@RequiredArgsConstructor
public class FootBallController {
    private final FootBallService footBallService;

    @PostMapping("add-team")
    public FootBallTeam addTeam(@RequestBody FootBallTeam team){
        System.out.println(team);
        return footBallService.addTeam(team);
    }
    @PostMapping("add-game")
    public FootBallGame addgame(@RequestBody FootBallGame game){
        System.out.println(game);
        return footBallService.addGame(game);
    }
    @PostMapping("update")
    public Integer update(@RequestParam Integer gameId,@RequestParam Integer teamId){
        return footBallService.update(gameId,teamId);
    }
    @GetMapping("get-teams")
    public ResponseEntity<Object> getTeams(){
        System.out.println("In get teams");
        return new ResponseEntity<>(footBallService.getTeams(), HttpStatus.OK);
    }
    @GetMapping("get-games")
    public ResponseEntity<Object> getgames(){
        System.out.println("In get games");
        return new ResponseEntity<>(footBallService.getGames(), HttpStatus.OK);
    }
}
