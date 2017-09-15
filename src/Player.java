import com.sun.java.browser.plugin2.DOM;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private int playerId;
    private ArrayList<Domino> hand = new ArrayList<Domino>();
    int dominoSelected = -1;

    /**
     * creates instance of play with a private hand.
     * @param playerId
     * @param hand
     */
    public Player(int playerId, ArrayList hand)
    {
        this.playerId = playerId;
        this.hand = hand;
    }

    /**
     * checks user input to make sure that numbers match.
     * @param theCurrGame
     * @param addToRight
     * @return
     */
    boolean isLegal (Game theCurrGame, Boolean addToRight)
    {
        if (((theCurrGame.humanPlayer.getHand().get(dominoSelected).sideOne == theCurrGame.theBoard.getLeftSide() || theCurrGame.humanPlayer.getHand().get(dominoSelected).sideTwo == theCurrGame.theBoard.getLeftSide()) && addToRight == false)
                || ((theCurrGame.humanPlayer.getHand().get(dominoSelected).sideOne == theCurrGame.theBoard.getRightSide() || theCurrGame.humanPlayer.getHand().get(dominoSelected).sideTwo == theCurrGame.theBoard.getRightSide()) && addToRight == true))
        {
            System.out.println("is Legal is true");
            return true;
        }
        else
        {
            System.out.println("is Legal is false");
            return false;
        }
    }

    /**
     * The AI method to find a domino to be placed.
     * @param theCurrGame
     */
    public void findPieceAI (Game theCurrGame)
    {
        for (int handDomIndex = 0; handDomIndex < theCurrGame.AIPlayer.getHand().size(); handDomIndex++)
        {
            if (theCurrGame.theBoard.isEmpty())
            {
                theCurrGame.theBoard.addDominoToBoard(theCurrGame.AIPlayer.getHand().get(handDomIndex), true, true, theCurrGame.AIPlayer, handDomIndex);
                return;
            }
            else if (theCurrGame.AIPlayer.getHand().get(handDomIndex).sideOne == theCurrGame.theBoard.getLeftSide())
            {
                theCurrGame.theBoard.addDominoToBoard(theCurrGame.AIPlayer.getHand().get(handDomIndex), false, true, theCurrGame.AIPlayer, handDomIndex);
                return;
            }
            else if (theCurrGame.AIPlayer.getHand().get(handDomIndex).sideOne == theCurrGame.theBoard.getRightSide())
            {
                theCurrGame.theBoard.addDominoToBoard(theCurrGame.AIPlayer.getHand().get(handDomIndex), true, true, theCurrGame.AIPlayer, handDomIndex);
                return;
            }
            else if (theCurrGame.AIPlayer.getHand().get(handDomIndex).sideTwo == theCurrGame.theBoard.getLeftSide())
            {
                theCurrGame.theBoard.addDominoToBoard(theCurrGame.AIPlayer.getHand().get(handDomIndex), false, false, theCurrGame.AIPlayer, handDomIndex);
                return;
            }
            else if (theCurrGame.AIPlayer.getHand().get(handDomIndex).sideTwo == theCurrGame.theBoard.getRightSide())
            {
                theCurrGame.theBoard.addDominoToBoard(theCurrGame.AIPlayer.getHand().get(handDomIndex), true, false, theCurrGame.AIPlayer, handDomIndex);
                return;
            }
            else
            {
                System.out.println("AI is drawing from boneyard");
                drawFromBoneyard(theCurrGame, theCurrGame.AIPlayer);
            }
        }
    }

    /**
     * Calls the board to get a random domino to place in player's hand.
     * @param theCurrGame
     * @param playerDrawing
     */
    void drawFromBoneyard (Game theCurrGame, Player playerDrawing)
    {
        if (!theCurrGame.boneyard.bundle.isEmpty() && playerDrawing.getHandSize() < 7)
        {
            playerDrawing.getHand().add(theCurrGame.boneyard.getRandomDomino());
        }

    }

    /**
     * returns the player's hand.
     * @return
     */
    public ArrayList<Domino> getHand() {
        return hand;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    /**
     * gets the player's hand size.
     * @return
     */
    int getHandSize ()
    {
        return hand.size();
    }
}
