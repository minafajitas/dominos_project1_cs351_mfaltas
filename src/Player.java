import com.sun.java.browser.plugin2.DOM;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    int playerId;
    public ArrayList<Domino> hand = new ArrayList<Domino>();
    int dominoSelected = -1;

    public Player(int playerId, ArrayList hand)
    {
        this.playerId = playerId;
        this.hand = hand;
    }

    public void findPieceHuman(Board theBoard)
    {

    }

    public void findPieceAI (Board theBoard)
    {
        for (Domino handDom: hand)
        {
            if (theBoard.isEmpty())
            {
                theBoard.addDominoToBoard(handDom, true, true);
            }
            else if (handDom.sideOne == theBoard.getLeftSide())
            {
                theBoard.addDominoToBoard(handDom, false, true);
            }
            else if (handDom.sideOne == theBoard.getRightSide())
            {
                theBoard.addDominoToBoard(handDom, true, true);
            }
            else if (handDom.sideTwo == theBoard.getLeftSide())
            {
                theBoard.addDominoToBoard(handDom, false, false);
            }
            else if (handDom.sideTwo == theBoard.getRightSide())
            {
                theBoard.addDominoToBoard(handDom, false, false);
            }
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
