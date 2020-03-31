package edu.up.cs301.pig;

import org.junit.Test;

import static org.junit.Assert.*;

// These tests show that the getters and setters are working correctly, and are not being modified externally

public class PigGameStateTest {
    @Test
    public void getDieTest() {
        PigGameState testState = new PigGameState();
        testState.setDie(4);
        assertEquals(4, testState.getDie());
    }

    @Test
    public void getPlayer0scoreTest() {
        PigGameState testState = new PigGameState();
        testState.setPlayer0score(4);
        assertEquals(4, testState.getPlayer0score());
    }

    @Test
    public void getPlayer1scoreTest() {
        PigGameState testState = new PigGameState();
        testState.setPlayer1score(4);
        assertEquals(4, testState.getPlayer1score());
    }

    @Test
    public void getHoldTest() {
        PigGameState testState = new PigGameState();
        testState.setHold(4);
        assertEquals(4, testState.getHold());
    }

    @Test
    public void getTurnTest() {
        PigGameState testState = new PigGameState();
        testState.setTurn(4);
        assertEquals(4, testState.getTurn());
    }

    @Test
    public void SetDieTest() {
        PigGameState testState = new PigGameState();
        testState.setDie(4);
        assertEquals(4, testState.getDie());
    }
}