import java.util.ArrayList;

public class Board
{
    ArrayList<Domino> leftSideList;
    ArrayList<Domino> rightSideList;
    int leftSide, rightSide;
    Domino centerDomino;

    public Board ()
    {
        leftSideList = new ArrayList<Domino>();
        rightSideList = new ArrayList<Domino>();

    }

    public boolean isEmpty()
    {
        if (leftSideList.isEmpty() && rightSideList.isEmpty()) {
            return true;
        }
        else
        {
            return false;
        }
    }

    //left side = side one
    //right side = side two

    public void addDominoToBoard (Domino addedDom, boolean rightSide, boolean sideOne)
    {
        if (leftSideList.isEmpty() && rightSideList.isEmpty()) {
            centerDomino = addedDom;
            this.leftSide = addedDom.sideOne;
            this.rightSide = addedDom.sideTwo;
        }
        else if (rightSide == true)
        {
            if (sideOne == false)
            {
                int temp = addedDom.sideOne;
                addedDom.sideOne = addedDom.sideTwo;
                addedDom.sideTwo = temp;
            }
            this.rightSideList.add(addedDom);
            this.rightSide = addedDom.sideTwo;
        }
        else
        {
            if (sideOne == true)
            {
                int temp = addedDom.sideOne;
                addedDom.sideOne = addedDom.sideTwo;
                addedDom.sideTwo = temp;
            }
            this.leftSideList.add(addedDom);
            this.leftSide = addedDom.sideOne;
        }
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

    public int getRightSide()
    {
         return rightSide;
    }

    public int getLeftSide()
    {
        return leftSide;
    }
}
