import java.util.ArrayList;

public class Board
{
    ArrayList<Domino> leftSideList;
    ArrayList<Domino> rightSideList;
    private int leftSide, rightSide;
    Domino centerDomino;

    /**
     * creates a new instrance of the board and sets two arrays; one to the left side of the center domino and one to the right.
     */
    public Board ()
    {
        leftSideList = new ArrayList<Domino>();
        rightSideList = new ArrayList<Domino>();
    }

    /**
     * checks if the board is empty.
     * @return
     */
    public boolean isEmpty()
    {
        if (leftSideList.isEmpty() && rightSideList.isEmpty() && centerDomino == null) {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * add a domino to the board. has to specify which side matches and whether adding to the left side or right side.
     * @param addedDom
     * @param rightSide
     * @param sideOne
     * @param currPlayer
     * @param indOfDomAdded
     */
    //left side = side one
    //right side = side two
    public void addDominoToBoard (Domino addedDom, boolean rightSide, boolean sideOne, Player currPlayer, int indOfDomAdded)
    {
        if (leftSideList.isEmpty() && rightSideList.isEmpty() && centerDomino == null)
        {
            System.out.println("in board class, both right and side lists are empty");
            centerDomino = addedDom;
            this.leftSide = addedDom.sideOne;
            this.rightSide = addedDom.sideTwo;
        }
        else if (rightSide == true)
        {
            if (sideOne == false)
            {
                addedDom.rotateDomino();
            }
            this.rightSideList.add(addedDom);
            this.rightSide = addedDom.sideTwo;
        }
        else
        {
            System.out.println("board class, adding to left list");
            if (sideOne == true)
            {
                addedDom.rotateDomino();
            }
            this.leftSideList.add(addedDom);
            this.leftSide = addedDom.sideOne;
        }
//        currPlayer.getHand().set(indOfDomAdded, null);
        currPlayer.getHand().remove(indOfDomAdded);
    }

    public void printBoard()
    {
        for (Domino dom: leftSideList)
        {
            System.out.print(" |" + dom.sideOne + "-" + dom.sideTwo + "| ");
        }
        System.out.print(" |||" + centerDomino.sideOne + "-" + centerDomino.sideTwo + "||| ");
        for (Domino dom: rightSideList)
        {
            System.out.print(" |" + dom.sideOne + "-" + dom.sideTwo + "| ");
        }
    }

    /**
     * gets the exposed number of the last domino in the right side array.
     * @return
     */
    public int getRightSide()
    {
        return rightSide;
    }

    /**
     * get the exposed number of the last domino in the left side array.
     * @return
     */
    public int getLeftSide()
    {
        return leftSide;
    }
}
