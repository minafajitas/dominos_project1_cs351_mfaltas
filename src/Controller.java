import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Controller extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }


    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Mina Faltas's dominos Adventure DLC");
        Game newGame = new Game();

        //defining necessary banes and boxes
        Stage gameStage  = new Stage();
        StackPane totalPane = new StackPane();
        BorderPane gameInterface = new BorderPane();
        HBox hand_buttons = new HBox();
        HBox topBox = new HBox();
        VBox leftBox = new VBox();
        VBox rightBox = new VBox();
        VBox handBox = new VBox();
        HBox handImagesBox = new HBox();
        VBox boardBox = new VBox();


        if (!newGame.humanPlayer.hand.isEmpty())
        {
            for (int i = 0; i < newGame.humanPlayer.getHandSize(); i++)
            {
                handImagesBox.getChildren().addAll(newGame.humanPlayer.getHand().get(i).getImage());
            }
        }

//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(0),false, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(1),true, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(2),true, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(3),true, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(4),true, true);
//
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(0),false, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(1),false, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(2),false, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(3),false, true);
//        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(4),false, true);

        boardBox.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        //defining necessary buttons
        Button domino1 = new Button("Place domino 1");
        Button domino2 = new Button("Place domino 2");
        Button domino3 = new Button("Place domino 3");
        Button domino4 = new Button("Place domino 4");
        Button domino5 = new Button("Place domino 5");
        Button domino6 = new Button("Place domino 6");
        Button domino7 = new Button("Place domino 7");
        Button placeLeft = new Button("Place on left side");
        Button placeRight = new Button("Place on right side");

        //placing all the boxes in appropriate place in border layout
        gameInterface.setTop(topBox);
        gameInterface.setLeft(leftBox);
        gameInterface.setRight(rightBox);
        leftBox.getChildren().add(placeLeft);
        rightBox.getChildren().add(placeRight);
        gameInterface.setCenter(boardBox);
        handBox.getChildren().add(handImagesBox);
        hand_buttons.getChildren().addAll(domino1, domino2, domino3, domino4, domino5, domino6, domino7);
        handBox.getChildren().add(hand_buttons);
        gameInterface.setBottom(handBox);

        EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               if (event.getSource() == domino1) newGame.humanPlayer.dominoSelected = 0;
               else if (event.getSource() == domino2) newGame.humanPlayer.dominoSelected = 1;
               else if (event.getSource() == domino3) newGame.humanPlayer.dominoSelected = 2;
               else if (event.getSource() == domino4) newGame.humanPlayer.dominoSelected = 3;
               else if (event.getSource() == domino5) newGame.humanPlayer.dominoSelected = 4;
               else if (event.getSource() == domino6) newGame.humanPlayer.dominoSelected = 5;
               else if (event.getSource() == domino7) newGame.humanPlayer.dominoSelected = 6;
            }
        };

        //set the actions for domino buttons
        domino1.setOnAction(eh);
        domino2.setOnAction(eh);
        domino3.setOnAction(eh);
        domino4.setOnAction(eh);
        domino5.setOnAction(eh);
        domino6.setOnAction(eh);
        domino7.setOnAction(eh);

        placeRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (newGame.humanPlayer.dominoSelected != -1)
                {
                    newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(newGame.humanPlayer.dominoSelected),true, true);
                }
                paintTheBoard(newGame, boardBox);
            }
        });

        placeLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (newGame.humanPlayer.dominoSelected != -1)
                {
                    newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(newGame.humanPlayer.dominoSelected),false, true);
                }
                paintTheBoard(newGame, boardBox);

            }
        });



        //adding the border layout to a stack pane for scene display and setting backgroud color
        gameInterface.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        totalPane.getChildren().add(gameInterface);


        //set things on the primary stage
        gameStage.setScene(new Scene(totalPane,1000,1000));
        Button startGameButton = new Button();
        StackPane mainMenu = new StackPane();
        mainMenu.getChildren().add(startGameButton);
        primaryStage.setScene(new Scene(mainMenu, 300, 500));

        startGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("Get ready");
                gameStage.show();
            }
        });

        startGameButton.setText("Start the game");
        primaryStage.show();
    }

    void paintTheBoard (Game newGame, VBox boardBox)
    {
        if (!newGame.theBoard.isEmpty())
        {
            double newX = 390;
            double newY = 350;
            int newXForLeft = 390;
            int newYForLeft = 450;
            double rotation = 90.0;
            System.out.println("board is not empty");
            ImageView iv1 = newGame.theBoard.centerDomino.getImage();
            iv1.setFitWidth(20.0);
            iv1.setFitHeight(50.0);
            iv1.setPreserveRatio(true);
            iv1.setRotate(rotation);
            iv1.setTranslateX(newX);
            iv1.setTranslateY(newY);
            boardBox.getChildren().clear();
            boardBox.getChildren().add(iv1);

            if (!newGame.theBoard.rightSideList.isEmpty())
            {
                newX = 390;
                newY = 350;
                System.out.println("right side is not empty");
                for (int i = 0; i < newGame.theBoard.rightSideList.size(); i++)
                {
                    newX = newX + 20;
                    if (i%2 == 0)
                    {
                        System.out.println("goes in here when i is " + i);
                        newY += -20;
                    }
                    else
                    {
                        newY += -60;
                    }
                    if (newGame.theBoard.rightSideList.get(i).rotated == true)
                    {
                        rotation = -90.0;
                    }
                    ImageView ivRightSide = newGame.theBoard.rightSideList.get(i).getImage();
                    ivRightSide.setFitWidth(20.0);
                    ivRightSide.setFitHeight(50.0);
                    ivRightSide.setPreserveRatio(true);
                    ivRightSide.setRotate(rotation);
                    ivRightSide.setTranslateX(newX);
                    ivRightSide.setTranslateY(newY);
                    boardBox.getChildren().add(ivRightSide);
                }
            }
            if (!newGame.theBoard.leftSideList.isEmpty())
            {
                for (int i = (newGame.theBoard.leftSideList.size()-1); i >= 0; i--)
                {
                    newXForLeft = newXForLeft + 20;
                    if (i % 2 == 0)
                    {
                        newYForLeft -= 20;
                    }
                    else
                    {
                        newYForLeft -= 60;
                    }
                    if (newGame.theBoard.leftSideList.get(i).rotated == true)
                    {
                        rotation = -90.0;
                    }
                    ImageView ivLeftSide = newGame.theBoard.leftSideList.get(i).getImage();
                    ivLeftSide.setFitWidth(20.0);
                    ivLeftSide.setFitHeight(50.0);
                    ivLeftSide.setPreserveRatio(true);
                    ivLeftSide.setRotate(rotation);
                    ivLeftSide.setTranslateX(newXForLeft);
                    ivLeftSide.setTranslateY(newYForLeft);
                    boardBox.getChildren().add(ivLeftSide);
                }
            }
        }
    }
}