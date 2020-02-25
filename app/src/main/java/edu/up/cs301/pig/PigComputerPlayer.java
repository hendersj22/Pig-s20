package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.Game;
import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;
import edu.up.cs301.game.GameFramework.utilities.Tickable;
import java.util.*;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState copy = new PigGameState((PigGameState) info);
        if(copy.getTurn() != super.playerNum) {
            return;
        } else {
            Random rand = new Random();
            int choice = rand.nextInt(2);
            if(choice == 0) {
                GameAction action = new PigHoldAction(this);
                game.sendAction(action);
            } else {
                GameAction action = new PigRollAction(this);
                game.sendAction(action);
            }
        }
    }//receiveInfo

}
