import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

        HBox hand_buttons = new HBox();
        VBox leftBox = new VBox();
        leftBox.setMaxSize(800,100);
        VBox rightBox = new VBox();
        rightBox.setMaxSize(800,100);
        HBox boardBox = new HBox();
        Button domino1 = new Button("Place domino 1");
        Button domino2 = new Button("Place domino 2");
        Button domino3 = new Button("Place domino 3");
        Button domino4 = new Button("Place domino 4");
        Button domino5 = new Button("Place domino 5");
        Button domino6 = new Button("Place domino 6");
        Button domino7 = new Button("Place domino 7");
        Button placeLeft = new Button("Place on left side");
        Button placeRight = new Button("Place on right side");

        leftBox.getChildren().add(placeLeft);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        rightBox.getChildren().add(placeRight);
        rightBox.setAlignment(Pos.CENTER_RIGHT);

        hand_buttons.getChildren().addAll(domino1, domino2, domino3, domino4, domino5, domino6, domino7);
        StackPane gameInterface = new StackPane();
        gameInterface.getChildren().add(hand_buttons);
        gameInterface.getChildren().add(leftBox);
        gameInterface.getChildren().add(rightBox);
        hand_buttons.setAlignment(Pos.BOTTOM_CENTER);
        Stage gameStage  = new Stage();
        gameStage.setScene(new Scene(gameInterface,1000,1000));

        ImageView iv1 = new ImageView();
        iv1.setImage(new Image("blank-blank.png"));
        boardBox.getChildren().add(iv1);
        boardBox.setAlignment(Pos.CENTER);
        gameInterface.getChildren().add(boardBox);

        Button startGameButton = new Button();
        StackPane mainMenu = new StackPane();
        mainMenu.getChildren().add(startGameButton);
        primaryStage.setScene(new Scene(mainMenu, 300, 500));



        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Get ready");
                Game newGame = new Game();
                gameStage.show();
            }
        });

        startGameButton.setText("Start the game");
        primaryStage.show();
    }
}

//    ImageView iv1 = new ImageView();
//    ImageView iv2 = new ImageView();
//    ImageView iv3 = new ImageView();
//    ImageView iv4 = new ImageView();
//    ImageView iv5 = new ImageView();
//    ImageView iv6 = new ImageView();
//    ImageView iv7 = new ImageView();
//
//        for (int i = 0; i <= newGame.humanPlayer.getHandSize(); i++)
//                {
//                if (newGame.humanPlayer.hand.get(i).sideOne == 0 || newGame.humanPlayer.hand.get(i).sideTwo == 0)
//                {
//                if (newGame.humanPlayer.hand.get(i).sideOne == 0 || newGame.humanPlayer.hand.get(i).sideTwo == 0)
//                {
//                iv1.setImage(new Image("blank-blank.png"));
//                }
//                if (newGame.humanPlayer.hand.get(i).sideOne == 1 || newGame.humanPlayer.hand.get(i).sideTwo == 1)
//                {
//                iv1.setImage(new Image("blank-one.png"));
//                }
//                }
//                }