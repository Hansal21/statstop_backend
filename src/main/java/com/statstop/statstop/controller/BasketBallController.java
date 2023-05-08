package com.statstop.statstop.controller;

import com.statstop.statstop.entity.BasketBallGame;
import com.statstop.statstop.entity.BasketBallTeam;
import com.statstop.statstop.service.BasketBallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basketball")
@RequiredArgsConstructor
public class BasketBallController {
    private final BasketBallService basketBallService;

    @PostMapping("add-team")
    public BasketBallTeam addTeam(@RequestBody BasketBallTeam team){
        System.out.println(team);
        return basketBallService.addTeam(team);
    }
    @PostMapping("add-game")
    public BasketBallGame addgame(@RequestBody BasketBallGame game){
        System.out.println(game);
        return basketBallService.addGame(game);
    }
    @PostMapping("update")
    public Integer update(@RequestParam Integer gameId, @RequestParam Integer teamId,@RequestParam Integer points){
        return basketBallService.update(gameId,teamId,points);
    }
    @GetMapping("get-teams")
    public ResponseEntity<Object> getTeams(){
        System.out.println("In get teams");
        return new ResponseEntity<>(basketBallService.getTeams(), HttpStatus.OK);
    }
    @GetMapping("get-games")
    public ResponseEntity<Object> getgames(){
        System.out.println("In get games");
        return new ResponseEntity<>(basketBallService.getGames(), HttpStatus.OK);
    }
}
