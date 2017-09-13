import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Domino {

    int sideOne;
    int sideTwo;
    boolean up;
    boolean rotated;
    String imageText;


    public Domino (int sideOne, int sideTwo)
    {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.up = false;
        this.rotated = false;
        imageText = sideTwo + "-" + sideOne + ".png";
    }

    public void rotateDomino ()
    {
        int temp = sideOne;
        sideOne = sideTwo;
        sideTwo = temp;

        if (rotated == true)
        {
            rotated = false;
        }
        else
        {
            rotated = true;
        }

    }

    public ImageView getImage ()
    {
        boolean rotateInGetImage = false;

        if (rotated == true)
        {
            System.out.println("Rotating in get Image");
            rotateDomino();
            rotateInGetImage = true;
        }
        System.out.println(imageText);
        Image dominoImage = new Image(imageText);
        ImageView dominoImageView = new ImageView();
        dominoImageView.setImage(dominoImage);

        if (rotateInGetImage == true)
        {
            rotateDomino();
        }
        return dominoImageView;

    }

}
