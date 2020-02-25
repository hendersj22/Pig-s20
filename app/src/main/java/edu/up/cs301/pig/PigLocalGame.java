package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.gameConfiguration.GameConfig;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import java.util.*;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */

    private PigGameState officialState;


    public PigLocalGame() {

        officialState = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (officialState.getTurn() == playerIdx)
            return true;
        else
            return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction) {
            if (officialState.getTurn() == 0) {
                officialState.setPlayer0score(officialState.getPlayer0score() + officialState.getHold());
            } else {
                officialState.setPlayer1score(officialState.getPlayer1score() + officialState.getHold());
            }
            officialState.setHold(0);
            if (players.length == 2) {
                officialState.setTurn(1 - officialState.getTurn());
            }
            return true;
        } else if (action instanceof PigRollAction) {
            Random rand = new Random();
            int dice = rand.nextInt(6) + 1;
            if (dice != 1) {
                officialState.setHold(dice + officialState.getHold());
            } else {
                officialState.setHold(0);
                if (players.length == 2) {
                    officialState.setTurn(1 - officialState.getTurn());
                }

            }
            return true;

        } else {
            return false;

        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

        PigGameState toSend = new PigGameState(officialState);
        p.sendInfo(toSend);


    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return a message that tells who has won the game, or null if the
     * game is not over
     */
    @Override
    protected String checkIfGameOver() {

        String playerName;

        if (officialState.getPlayer0score() >= 50) {
            playerName = "Player Zero";
            return playerName;
        }

        if (officialState.getPlayer1score() >= 50) {
            playerName = "Player One";
            return playerName;
        }

        return null;
    }

}// class PigLocalGame
