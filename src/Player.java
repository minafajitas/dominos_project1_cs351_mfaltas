import com.sun.java.browser.plugin2.DOM;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private int playerId;
    private ArrayList<Domino> hand = new ArrayList<Domino>();
    int dominoSelected = -1;

    public Player(int playerId, ArrayList hand)
    {
        this.playerId = playerId;
        this.hand = hand;
    }

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
                theCurrGame.theBoard.addDominoToBoard(theCurrGame.AIPlayer.getHand().get(handDomIndex), false, false, theCurrGame.AIPlayer, handDomIndex);
                return;
            }
            else
            {
                System.out.println("AI is drawing from boneyard");
                drawFromBoneyard(theCurrGame, theCurrGame.AIPlayer);
            }
        }
    }

    void drawFromBoneyard (Game theCurrGame, Player playerDrawing)
    {
        if (!theCurrGame.boneyard.bundle.isEmpty() && playerDrawing.getHandSize() < 7)
        {
            playerDrawing.getHand().add(theCurrGame.boneyard.getRandomDomino());
        }

    }

    public ArrayList<Domino> getHand() {
        return hand;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    int getHandSize ()
    {
        return hand.size();
    }
}
