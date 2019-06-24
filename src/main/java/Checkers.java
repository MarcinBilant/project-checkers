import com.kodilla.ButtonParameters;
import com.kodilla.MoveResult;
import com.kodilla.PawnFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Checkers extends Application {

    private List<Button> blackButtons = PawnFactory.createButtons(12,true);
    private List<Button> whiteButtons = PawnFactory.createButtons(12,false);

    private Image imageback = new Image("images/board.jpg");
    private ImageView imageWhitePawn = new ImageView("images/white_pawn.png");
    private Image imageBlackPawnB = new Image("images/black_pawn.png");
    private Image imageBlackPawnW = new Image("images/white_pawn.png");
    private boolean isMoveBlack = false;
    private int whichColumn;
    private int whichRow;
    private int column;
    private int row;
    private int moveComputerLeftRight;
    private int whichComputerPawn;
    private String whichButton;
    private int whichColumnComputer;
    private int whichRowComputer;
    String nameButton;
    private boolean noMovePawn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(725, 610, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


        GridPane grid = new GridPane();
        //grid.setAlignment(Pos.CENTER_RIGHT);
        grid.setPadding(new Insets(0, 0, 0, 0));
        grid.setBackground(background);

        for (int i = 0; i < 12; i++) {
            ColumnConstraints column = new ColumnConstraints(60);
            grid.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints(60);
            grid.getRowConstraints().add(row);
        }


        grid.getColumnConstraints().add(new ColumnConstraints(120));
        grid.getRowConstraints().add(new RowConstraints(120));

        blackButtons.forEach(button-> buttonSetActionBlack(button, grid, true));
        whiteButtons.forEach(button-> buttonSetActionWhite(button, grid, false));


        Button buttonB1 = blackButtons.get(0);
        Button buttonB2 = blackButtons.get(1);
        Button buttonB3 = blackButtons.get(2);
        Button buttonB4 = blackButtons.get(3);
        Button buttonB5 = blackButtons.get(4);
        Button buttonB6 = blackButtons.get(5);
        Button buttonB7 = blackButtons.get(6);
        Button buttonB8 = blackButtons.get(7);
        Button buttonB9 = blackButtons.get(8);
        Button buttonB10 = blackButtons.get(9);
        Button buttonB11 = blackButtons.get(10);
        Button buttonB12 = blackButtons.get(11);


        grid.add(buttonB1, 1, 1);
        grid.add(buttonB2, 3, 1);
        grid.add(buttonB3, 5, 1);
        grid.add(buttonB4, 7, 1);
        grid.add(buttonB5, 2, 2);
        grid.add(buttonB6, 4, 2);
        grid.add(buttonB7, 6, 2);
        grid.add(buttonB8, 8, 2);
        grid.add(buttonB9, 1, 3);
        grid.add(buttonB10, 3, 3);
        grid.add(buttonB11, 5, 3);
        grid.add(buttonB12, 7, 3);

        Button buttonW1 = whiteButtons.get(0);
        Button buttonW2 = whiteButtons.get(1);
        Button buttonW3 = whiteButtons.get(2);
        Button buttonW4 = whiteButtons.get(3);
        Button buttonW5 = whiteButtons.get(4);
        Button buttonW6 = whiteButtons.get(5);
        Button buttonW7 = whiteButtons.get(6);
        Button buttonW8 = whiteButtons.get(7);
        Button buttonW9 = whiteButtons.get(8);
        Button buttonW10 = whiteButtons.get(9);
        Button buttonW11 = whiteButtons.get(10);
        Button buttonW12 = whiteButtons.get(11);

        grid.add(buttonW1, 2, 6);
        grid.add(buttonW2, 4, 6);
        grid.add(buttonW3, 6, 6);
        grid.add(buttonW4, 8, 6);
        grid.add(buttonW5, 1, 7);
        grid.add(buttonW6, 3, 7);
        grid.add(buttonW7, 5, 7);
        grid.add(buttonW8, 7, 7);
        grid.add(buttonW9, 2, 8);
        grid.add(buttonW10, 4, 8);
        grid.add(buttonW11, 6, 8);
        grid.add(buttonW12, 8, 8);


        Scene scene = new Scene(grid, 725, 610, Color.BLACK);


        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();

    }

    private void computerMove(GridPane grid) {
        makeMove( false);

        boolean correctMove = false;

        if (!noMovePawn) {

            do {
                moveComputerRandom();
                if (moveComputerLeftRight == 0) {
                    correctMove = moveComputerLeft(grid, blackButtons.get(whichComputerPawn - 1));
                } else {
                    correctMove = moveComputerRight(grid, blackButtons.get(whichComputerPawn - 1));
                }
            } while (!correctMove);
        }
    }

    public void makeMove(boolean isBlackPawn) {


        if (!isBlackPawn && !isMoveBlack) {
            System.out.println("Wykonał ruch białymi");

            isMoveBlack = true;
        } else if (isBlackPawn && isMoveBlack) {
            System.out.println("Wykonał ruch czarnymi");
            isMoveBlack = false;
        } else {
            System.out.println("Błędny pionek");
        }
    }


    public void moveComputerRandom() {

        if (isMoveBlack) {
            Random random = new Random();

            whichComputerPawn = random.nextInt(12)+1;
            moveComputerLeftRight = random.nextInt(2);

        }
    }

    public boolean moveComputerLeft(GridPane grid, Button button) {

        whichColumnComputer = (int) button.getLayoutX() / 60;
        whichRowComputer = (int) button.getLayoutY() / 60;

        Node isEmptyLeft = getNodeFromGridPane(grid, whichColumnComputer - 1, whichRowComputer + 1);

        if (isEmptyLeft == null && whichColumnComputer - 1 <= 8 && whichRowComputer + 1 <= 8
                && whichColumnComputer - 1 > 0 && whichRowComputer + 1 > 0) {
            grid.getChildren().remove(button);
            grid.add(button, whichColumnComputer - 1, whichRowComputer + 1);
            return true;
        }
        return false;

    }

    public boolean moveComputerRight(GridPane grid, Button button) {

        whichColumnComputer = (int) button.getLayoutX() / 60;
        whichRowComputer = (int) button.getLayoutY() / 60;

        Node isEmptyRight = getNodeFromGridPane(grid, whichColumnComputer + 1, whichRowComputer + 1);

        if (isEmptyRight == null && whichColumnComputer + 1 <= 8 && whichRowComputer + 1 <= 8
                && whichColumnComputer + 1 > 0 && whichRowComputer + 1 > 0) {
            grid.getChildren().remove(button);
            grid.add(button, whichColumnComputer + 1, whichRowComputer + 1);
            return true;
        }
        return false;
    }


    public boolean mouseMovedReleased(MouseEvent event,GridPane grid, Button button, boolean isBlackPawn) {

        double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;

        if (!isBlackPawn && !isMoveBlack) {
            System.out.println("Wykonał ruch białymi");

            isMoveBlack = true;
        } else if (isBlackPawn && isMoveBlack) {
            System.out.println("Wykonał ruch czarnymi");
            isMoveBlack = false;
        } else {
            System.out.println("Błędny pionek");
        }

        Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
        if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
            grid.getChildren().remove(button);
            grid.add(button,whichColumn, whichRow);
            //grid.add(button,whichColumn+1,whichRow+1);


        }
        else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
            grid.getChildren().remove(button);
            grid.add(button,column,row);
            return noMovePawn = true;
        }

        else  {
            grid.getChildren().remove(button);
            grid.add(button,column,row);
            return noMovePawn = true;

        }

        if (whichColumn == column && whichRow == row) {
            return noMovePawn = true;

        }
        else {
            return noMovePawn = false;
        }

    }

    public void mouseMovedPressed(MouseEvent event, Button button) {
        double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;
        ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
        HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
        buttonParametersHashMap.put(button,buttonParameters);
        ButtonParameters parameters = buttonParametersHashMap.get(button);
        column = parameters.getColumn();
        row = parameters.getRow();
    }

   
    private Node getNodeFromGridPane(GridPane grid, int col, int row) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {

                return node;
            }
        }
        return null;
    }
    private void buttonSetActionWhite(Button button, GridPane grid, boolean isBlackPawn) {
        // button.setOnAction((e) -> {
        //    makeMove(true);
        // });
        button.setOnMousePressed((event) -> {
            mouseMovedPressed(event, button);
        });

        button.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, button,isBlackPawn);
            if(!isBlackPawn) {
                computerMove(grid);
            }
        });
    }

    private void buttonSetActionBlack(Button button, GridPane grid, boolean isBlackPawn) {
        // button.setOnAction((e) -> {
        //    makeMove(true);
        // });


        button.setOnMouseEntered(event -> {
            mouseMovedEntered(event,button);
        });

    }
    private void killPawnLeft() {


    }

    private void killPawnRight() {


    }

    public void mouseMovedEntered(MouseEvent event, Button button) {
       /* double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;
        ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
        HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
        buttonParametersHashMap.put(button,buttonParameters);
        ButtonParameters parameters = buttonParametersHashMap.get(button);
        column = parameters.getColumn();
        row = parameters.getRow(); */
        System.out.println("jestem nad pionkiem");
    }


}