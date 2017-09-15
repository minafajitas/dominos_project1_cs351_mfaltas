import java.util.ArrayList;
import java.util.Random;

/**
 * this class instantiates the boneyard.
 */
public class Bundle
{
    int maxDomino;
    ArrayList<Domino> bundle;

    public Bundle (int maxDomino)
    {
        this.maxDomino = maxDomino;
        bundle = new ArrayList<>();

        for (int i = maxDomino; i >= 0; i--)
        {
            for (int k = i; k >= 0; k--)
            {
                Domino newDom = new Domino(i, k);
                bundle.add(newDom);
            }
        }
    }

    /**
     * gets a random domino from the boneyard for the purpose of adding to a player hand.
     * Also removes that domino from the boneyard.
     * @return Domino
     */
    Domino getRandomDomino ()
    {
        Random rand = new Random();
        int randomInt = rand.nextInt(bundle.size()) + 0; //(max number) + min number
        Domino tempDomino = bundle.get(randomInt);
        bundle.remove(bundle.get(randomInt));
        return tempDomino;
    }

    public int getNumberOfDominos ()
    {
        return bundle.size();
    }

    /**
     * Creates a new boneyard by instantiating new dominos.
     * Also gives each player 7 dominos right away.
     * @param numRandDom
     * @return ArrayList
     */
    public ArrayList<Domino> getRandomDominoBundle(int numRandDom)
    {
        ArrayList randHand = new ArrayList<Domino>();

        for (int i = 0; i < numRandDom; i++)
        {
            Random rand = new Random();
            int randomInt = rand.nextInt(bundle.size()) + 0; //(max number) + min number
            //System.out.println("The random int is " + randomInt);
            bundle.get(randomInt).up = true;
            randHand.add(bundle.get(randomInt));
            bundle.remove(bundle.get(randomInt));
        }
        return randHand;
    }

    public void printBundle ()
    {
        for (Domino dom: bundle)
        {
            System.out.println(" |" + dom.sideOne + "-" + dom.sideTwo + "| ");
        }
    }
}