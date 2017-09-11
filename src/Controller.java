import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
//import java.awt.*;
import javafx.scene.image.Image;

public class Controller extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Mina Faltas's dominos");

        Button startGameButton = new Button();
        startGameButton.setText("Start the game");
        Image blankBlank = new Image("blank-blank.png");
        ImageView iv1 = new ImageView();
        iv1.setImage(blankBlank);
        HBox imageBox = new HBox();
        imageBox.getChildren().add(iv1);

        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Get ready");
                Game newGame = new Game();
            }
        });
        StackPane mainMenu = new StackPane();
        mainMenu.getChildren().add(imageBox);
        mainMenu.getChildren().add(startGameButton);
//        mainMenu.setAlignment(startGameButton, Pos.TOP_CENTER);
        primaryStage.setScene(new Scene(mainMenu, 300, 500));
        primaryStage.show();

        
    }
}
