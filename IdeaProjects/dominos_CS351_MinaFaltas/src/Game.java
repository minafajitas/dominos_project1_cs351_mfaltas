public class Game
{
    public static void main(String[] args)
    {
        Game newGame = new Game();
    }

    public void Game ()
    {

        Bundle Boneyard = new Bundle(28);
        Player humanPlayer = new Player(1, Boneyard.getRandomDominoBundle(7));
        Player AIPlayer = new Player(2, Boneyard.getRandomDominoBundle(7));

        System.out.println("hello world");

        humanPlayer.hand.printBundle();



    }
}
