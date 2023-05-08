package com.statstop.statstop.controller;

import com.statstop.statstop.entity.ThrowBallGame;
import com.statstop.statstop.entity.ThrowBallTeam;
import com.statstop.statstop.service.ThrowBallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("throwball")
@RequiredArgsConstructor
public class ThrowballController {
    private final ThrowBallService throwBallService;

    @PostMapping("add-team")
    public ThrowBallTeam addTeam(@RequestBody ThrowBallTeam team){
        System.out.println(team);
        return throwBallService.addTeam(team);
    }
    @PostMapping("add-game")
    public ThrowBallGame addgame(@RequestBody ThrowBallGame game){
        System.out.println(game);
        return throwBallService.addGame(game);
    }
    @PostMapping("update")
    public Integer update(@RequestParam Integer gameId, @RequestParam Integer teamId){
        return throwBallService.update(gameId,teamId);
    }
    @GetMapping("get-teams")
    public ResponseEntity<Object> getTeams(){
        System.out.println("In get teams");
        return new ResponseEntity<>(throwBallService.getTeams(), HttpStatus.OK);
    }
    @GetMapping("get-games")
    public ResponseEntity<Object> getgames(){
        System.out.println("In get games");
        return new ResponseEntity<>(throwBallService.getGames(), HttpStatus.OK);
    }
}
