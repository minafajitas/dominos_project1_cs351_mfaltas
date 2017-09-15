import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
        HBox mainMenu = new HBox();

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
        ScrollPane boardScroll = new ScrollPane(boardBox);
        boardScroll.setFitToHeight(true);

        //donate button
        Stage donateStage = new Stage();
        donateStage.setTitle("Donate Now!");
        BorderPane donateBorder = new BorderPane();
        Button donate = new Button("Donate now!");
        Button enterInfo = new Button("Enter");
        Text donateText = new Text();
        Text vladimirText = new Text();
        donateText.setText("Enter your bank account information belew. \n We accept credit, debit, cash, savings, visa, mastercard, and bitcoin");
        vladimirText.setText("I think we should not control the internet -Vladimir Putin");
        TextField donateTextField = new TextField();

        donateBorder.setTop(donateText);
        donateBorder.setCenter(donateTextField);
        donateBorder.setBottom(vladimirText);
        donateBorder.setRight(enterInfo);
        donateStage.setScene(new Scene(donateBorder, 500,100));
        mainMenu.getChildren().add(donate);

        donate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                donateStage.show();
            }
        });

        enterInfo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                donateTextField.setText("");
            }
        });


        //Set the box for a AI turn window
        Stage AITurnStage = new Stage();
        Text turnAIText = new Text();
        turnAIText.setText("The AI has put down a domino. It is your turn now");
        StackPane AITextPane = new StackPane();
        AITextPane.getChildren().add(turnAIText);
        AITurnStage.setTitle("AI has placed a domino");
        AITurnStage.setScene(new Scene(AITextPane, 300,40));

        //Creates the winning screens
        Stage winStageHuman = new Stage();
        Stage winStageAI = new Stage();
        Text winTextHuman = new Text();
        Text winTextAI = new Text();
        winTextHuman.setText("The Human player has won. \n For liberty and justice for all!");
        winTextAI.setText("The AI players has won");
        StackPane winPaneAI = new StackPane();
        StackPane winPaneHuman = new StackPane();
        winPaneAI.getChildren().add(winTextAI);
        winPaneHuman.getChildren().add(winTextHuman);
        winStageAI.setTitle("AI has won");
        winStageAI.setScene(new Scene(winPaneAI, 300,40));
        winStageHuman.setTitle("Human has won");
        winStageHuman.setScene(new Scene(winPaneHuman, 300,40));


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

        boardScroll.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
        boardBox.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

        //defining necessary buttons
        Button domino1 = new Button("Dunk domino 1");
        Button domino2 = new Button("Dunk domino 2");
        Button domino3 = new Button("Dunk domino 3");
        Button domino4 = new Button("Dunk domino 4");
        Button domino5 = new Button("Dunk domino 5");
        Button domino6 = new Button("Dunk domino 6");
        Button domino7 = new Button("Dunk domino 7");
        Button placeLeft = new Button("Dunk on left side");
        Button placeRight = new Button("Dunk on right side");
        Button drawFromBoneyard = new Button("Draw from the boneyard");
        Button passTurn = new Button("Skip turn");

        //placing all the boxes in appropriate place in border layout
        gameInterface.setTop(topBox);
        gameInterface.setLeft(leftBox);
        gameInterface.setRight(rightBox);
        leftBox.getChildren().add(placeLeft);
        rightBox.getChildren().add(placeRight);
        gameInterface.setCenter(boardScroll);//////////////////////////////////////////////////////////////////////////////////////////////////
        handBox.getChildren().add(handImagesBox);
        hand_buttons.getChildren().addAll(domino1, domino2, domino3, domino4, domino5, domino6, domino7, drawFromBoneyard, passTurn);
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

        paintHand(newGame, handImagesBox);

        placeRight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (newGame.humanPlayer.isLegal(newGame, true) || newGame.theBoard.isEmpty())
                {
                    if (newGame.humanPlayer.dominoSelected != -1 && newGame.humanPlayer.dominoSelected < newGame.humanPlayer.getHandSize())
                    {
                        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(newGame.humanPlayer.dominoSelected), true, true, newGame.humanPlayer, newGame.humanPlayer.dominoSelected);
                    }
                    newGame.AIPlayer.findPieceAI(newGame);
                    AITurnStage.show();
                    paintTheBoard(newGame, boardBox);
                    paintHand(newGame, handImagesBox);

                    if (checkWinConditions(newGame) == 1)
                    {
                        winStageHuman.show();
                    }
                    else if (checkWinConditions(newGame) == 2)
                    {
                        winStageAI.show();
                    }
                }
            }
        });

        placeLeft.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (newGame.humanPlayer.isLegal(newGame, false) || newGame.theBoard.isEmpty())
                {
                    if (newGame.humanPlayer.dominoSelected != -1 && newGame.humanPlayer.dominoSelected < newGame.humanPlayer.getHandSize())
                    {
                        newGame.theBoard.addDominoToBoard(newGame.humanPlayer.getHand().get(newGame.humanPlayer.dominoSelected), false, true, newGame.humanPlayer, newGame.humanPlayer.dominoSelected);
                    }
                    newGame.AIPlayer.findPieceAI(newGame);
                    AITurnStage.show();
                    paintTheBoard(newGame, boardBox);
                    paintHand(newGame, handImagesBox);

                    if (checkWinConditions(newGame) == 1)
                    {
                        winStageHuman.show();
                    }
                    else if (checkWinConditions(newGame) == 2)
                    {
                        winStageAI.show();
                    }
                }
            }
        });

        drawFromBoneyard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newGame.humanPlayer.drawFromBoneyard(newGame, newGame.humanPlayer);
                paintHand(newGame, handImagesBox);
            }
        });

        passTurn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (newGame.humanPlayer.getHandSize() == 7 || newGame.boneyard.bundle.isEmpty())
                {
                    newGame.AIPlayer.findPieceAI(newGame);
                    AITurnStage.show();
                    paintTheBoard(newGame, boardBox);
                    paintHand(newGame, handImagesBox);
                }
            }
        });

        //adding the border layout to a stack pane for scene display and setting backgroud color
        gameInterface.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        totalPane.getChildren().add(gameInterface);


        //set things on the primary stage
        gameStage.setScene(new Scene(totalPane,1000,1000));
        Button startGameButton = new Button();
        mainMenu.getChildren().add(startGameButton);
        primaryStage.setScene(new Scene(mainMenu, 450, 50));

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

    /**
     * This method paints the board. Called every turn.
     * @param newGame
     * @param boardBox
     */
    void paintTheBoard (Game newGame, VBox boardBox)
    {
        if (!newGame.theBoard.isEmpty())
        {
            double newX = 390;
            double newY = 350;
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
                    if (newGame.theBoard.rightSideList.get(i) != null)
                    {
                        ImageView ivRightSide = newGame.theBoard.rightSideList.get(i).getImage();
                        ivRightSide.setFitWidth(20.0);
                        ivRightSide.setFitHeight(50.0);
                        ivRightSide.setPreserveRatio(true);
                        ivRightSide.setRotate(rotation);
                        rotation = 90.0;
                        ivRightSide.setTranslateX(newX);
                        ivRightSide.setTranslateY(newY);
                        System.out.println("newX is " + newX + " newY is " + newY);
                        boardBox.getChildren().add(ivRightSide);
                    }
//                    System.out.println("Position X right : " + ivRightSide.getBoundsInParent() + "\n Position Y for right " + ivRightSide.getBoundsInParent());
                }
            }
            if (!newGame.theBoard.leftSideList.isEmpty())
            {
                double newXForLeft = 460 - 85;
                double newYForLeft = newY - 10; //misplaces they right y
                for (int i = 0; i < (newGame.theBoard.leftSideList.size());  i++)
                {
                    if (i%2 == 0)
                    {
                        newYForLeft -= 20;
                        newXForLeft = newXForLeft - 15;
                    }
                    else
                    {
                        newYForLeft -= 60;
                        newXForLeft = newXForLeft - 25;
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
                    rotation = 90.0;
                    ivLeftSide.setTranslateX(newXForLeft);
                    ivLeftSide.setTranslateY(newYForLeft);
                    boardBox.getChildren().add(ivLeftSide);
                }
            }
        }
    }

    /**
     * Paints the hand. Called every turn.
     * @param newGame
     * @param handImagesBox
     */
    void paintHand (Game newGame, HBox handImagesBox)
    {
        handImagesBox.getChildren().clear();
        if (!newGame.humanPlayer.getHand().isEmpty())
        {
            for (int i = 0; i < newGame.humanPlayer.getHandSize(); i++)
            {
                handImagesBox.getChildren().addAll(newGame.humanPlayer.getHand().get(i).getImage());
            }
        }
    }

    /**
     * checks if any player has an empty hand to display the winning message; called by the next turn buttons.
     * @param theCurrGame
     * @return
     */
    int checkWinConditions (Game theCurrGame)
    {
        if (theCurrGame.humanPlayer.getHandSize() == 0)
        {
            return 1;

        }
        else if (theCurrGame.AIPlayer.getHandSize() == 0)
        {
            return 2;
        }
        else
        {
            return -1;
        }
    }
}