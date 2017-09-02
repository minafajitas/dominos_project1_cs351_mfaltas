public class Game
{

    public Game ()
    {

        Bundle boneyard = new Bundle(6);
        boneyard.printBundle();
        Player humanPlayer = new Player(1, boneyard.getRandomDominoBundle(7));
        Player AIPlayer = new Player(2, boneyard.getRandomDominoBundle(7));

        boneyard.printBundle();

        System.out.println("hello world");

        //System.out.println(boneyard.getNumberOfDominos());

        //humanPlayer.hand.printBundle();



    }
}
