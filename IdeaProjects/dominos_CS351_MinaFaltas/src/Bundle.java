import java.util.ArrayList;
import java.util.Random;

public class Bundle
{
    int maxCard;
    ArrayList<Domino> bundle;

    public Bundle (int maxCard)
    {
        this.maxCard = maxCard;
        bundle = new ArrayList<Domino>();

        for (int i = 0; i <= maxCard; i++)
        {
            for (int k = i; k <= maxCard; k++)
            {
                Domino newDom = new Domino(i, k);
                bundle.add(newDom);
            }
        }
    }

    private void addDomino (Domino domino)
    {
        bundle.add(domino);
    }

    private void RemoveDomino (Domino domino)
    {
        bundle.remove(domino);
    }

    public Bundle getRandomDominoBundle(int numRandDom)
    {
        Bundle randBundle = new Bundle(numRandDom);

        for (int i = 0; i < numRandDom; i++)
        {
            Random rand = new Random();
            int randomInt = rand.nextInt(28) + 1;
            bundle.get(randomInt).up = true;
            randBundle.addDomino(bundle.get(randomInt));
            bundle.remove(bundle.get(randomInt));
        }

        return randBundle;

    }

    public void printBundle ()
    {
        for (Domino dom: bundle)
        {
            System.out.println(" |" + dom.sideOne + "-" + dom.sideTwo + "| ");
        }

    }
}
