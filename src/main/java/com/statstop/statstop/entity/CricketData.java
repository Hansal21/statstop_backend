package com.statstop.statstop.entity;

import jakarta.persistence.*;

@Entity
@Table(name =  "event_data")
public class CricketData {

    @Id
    @Column(name="event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ball_no")
    private int ballNum;

    @Column(name="match_id")
    private int matchId;

    @Column(name="inning_no")
    private int inningNum;

    @Column(name="bowler")
    private String bowler;

    @Column(name="batsman1")
    private String batmanOnStrike;

    @Column(name="batsman2")
    private String otherBatsman;

    @Column(name="wicket")
    private int wicket;

    @Column(name="runs_scored")
    private int runScoredThisBall;

    @Column(name="total_runs_scored")
    private int totalScore;

    @Column(name="total_wickets")
    private int totalWickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBallNum() {
        return ballNum;
    }

    public void setBallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getInningNum() {
        return inningNum;
    }

    public void setInningNum(int inningNum) {
        this.inningNum = inningNum;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getBatmanOnStrike() {
        return batmanOnStrike;
    }

    public void setBatmanOnStrike(String batmanOnStrike) {
        this.batmanOnStrike = batmanOnStrike;
    }

    public String getOtherBatsman() {
        return otherBatsman;
    }

    public void setOtherBatsman(String otherBatsman) {
        this.otherBatsman = otherBatsman;
    }

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }

    public int getRunScoredThisBall() {
        return runScoredThisBall;
    }

    public void setRunScoredThisBall(int runScoredThisBall) {
        this.runScoredThisBall = runScoredThisBall;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

}
