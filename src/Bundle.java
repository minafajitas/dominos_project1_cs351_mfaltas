import java.util.ArrayList;
import java.util.Random;

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

    public void addDomino (Domino domino)
    {
        bundle.add(domino);
    }

    public void RemoveDomino (Domino domino)
    {
        bundle.remove(domino);
    }

    public int getNumberOfDominos ()
    {
        return bundle.size();
    }

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