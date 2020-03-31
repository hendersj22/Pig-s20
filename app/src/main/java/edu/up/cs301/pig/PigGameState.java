package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;

public class  PigGameState extends GameState {
    private int turn;
    private int player0score;
    private int player1score;
    private int hold;
    private int die;

    public PigGameState() {
        turn = 0;
        player0score = 0;
        player1score = 0;
        hold = 0;
        die = 0;

    }

    public PigGameState(PigGameState pigGameState) {
        turn = pigGameState.getTurn();
        player0score = pigGameState.getPlayer0score();
        player1score = pigGameState.getPlayer1score();
        hold = pigGameState.getHold();
        die = pigGameState.getDie();

    }

    public int getDie() {
        return die;
    }

    public int getPlayer0score() {
        return player0score;
    }

    public int getPlayer1score() {
        return player1score;
    }

    public int getHold() {
        return hold;
    }

    public int getTurn() {
        return turn;
    }

    public void setDie(int die) {
        this.die = die;
    }

    public void setHold(int hold) {
        this.hold = hold;
    }

    public void setPlayer0score(int player0score) {
        this.player0score = player0score;
    }

    public void setPlayer1score(int player1score) {
        this.player1score = player1score;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}


