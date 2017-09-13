public class Game
{
    Bundle boneyard;
    Board theBoard;
    Player humanPlayer;
    Player AIPlayer;

    public Game ()
    {

        //instantiates a new boneyard and 7 dominos to each player.
        boneyard = new Bundle(6);
        theBoard = new Board();
        humanPlayer = new Player(1, boneyard.getRandomDominoBundle(7));
        AIPlayer = new Player(2, boneyard.getRandomDominoBundle(7));

        boolean gameOver = false;
//        while (gameOver == false)
//        {
//            AIPlayer.findPieceAI(theBoard);
//            humanPlayer.findPieceHuman(theBoard);
//
//            if (AIPlayer.hand.isEmpty() || humanPlayer.hand.isEmpty())
//            {
//                gameOver = true;
//            }
//        }

        if (gameOver == true)
        {
            if (AIPlayer.hand.isEmpty())
            {
                System.out.println("AI is winner");
            }
            else
            {
                System.out.println("Human Player is winner");
            }
        }
    }
}
