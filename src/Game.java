public class Game
{
    Bundle boneyard;
    Board theBoard;
    Player humanPlayer;
    Player AIPlayer;

    /**
     * creates instances of everything.
     */
    public Game ()
    {
        //instantiates a new boneyard and 7 dominos to each player.
        boneyard = new Bundle(6);
        theBoard = new Board();
        humanPlayer = new Player(1, boneyard.getRandomDominoBundle(7));
        AIPlayer = new Player(2, boneyard.getRandomDominoBundle(7));

        boolean gameOver = false;

        if (gameOver == true)
        {
            if (AIPlayer.getHand().isEmpty())
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
