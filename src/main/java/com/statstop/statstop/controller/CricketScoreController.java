package com.statstop.statstop.controller;

import com.statstop.statstop.entity.CricketData;
import com.statstop.statstop.repository.CricketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cricket-score")
public class CricketScoreController {
    @Autowired
    private CricketRepository cricketRepository;

    @GetMapping(value="live-score")
    public CricketData getScorecard(){
        return cricketRepository.findTopByOrderByIdDesc();

    }
}
