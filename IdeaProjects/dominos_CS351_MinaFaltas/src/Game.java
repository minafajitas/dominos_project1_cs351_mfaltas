public class Game
{

    public Game ()
    {

        //instantiates a new boneyard and 7 dominos to each player.
        Bundle boneyard = new Bundle(6);
        Board theBoard = new Board();
        Player humanPlayer = new Player(1, boneyard.getRandomDominoBundle(7));
        Player AIPlayer = new Player(2, boneyard.getRandomDominoBundle(7));

        boolean gameOver = false;
        while (gameOver == false)
        {
            AIPlayer.findPieceAI(theBoard);
            humanPlayer.findPieceHuman(theBoard);

            if (!AIPlayer.hand.isEmpty() && !!humanPlayer.hand.isEmpty())
            {
                gameOver = true;
            }
        }

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
