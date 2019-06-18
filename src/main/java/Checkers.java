
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
        List<Button> blackButtons = PawnFactory.createButtons(12,true);
        List<Button> whiteButtons = PawnFactory.createButtons(12,false);
        blackButtons.forEach(button-> buttonSetAction(button, grid));
        whiteButtons.forEach(button-> buttonSetAction(button, grid));


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

        setGraphicsWhite(buttonW12);
        buttonW12.setOnAction((e) -> {
            System.out.println("wartość zmienne isMoveBlack  " + isMoveBlack);
            makeMove(e, false);
            System.out.println("wartość zmienne isMoveBlack  " + isMoveBlack);
            moveComputerRandom();
            System.out.println("ComputerPawn   " + whichComputerPawn + " ComputerLeftRight  "  + moveComputerLeftRight );
            if (whichComputerPawn == 1 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB1);
            }
            if (whichComputerPawn == 1 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB1);
            }
            if (whichComputerPawn == 2 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB2);
            }
            if (whichComputerPawn == 2 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB2);
            }
            if (whichComputerPawn == 3 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB3);
            }
            if (whichComputerPawn == 3 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB3);
            }
            if (whichComputerPawn == 4 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB4);
            }
            if (whichComputerPawn == 4 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB4);
            }
            if (whichComputerPawn == 5 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB5);
            }
            if (whichComputerPawn == 5 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB5);
            }
            if (whichComputerPawn == 6 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB6);
            }
            if (whichComputerPawn == 6 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB6);
            }
            if (whichComputerPawn == 7 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB7);
            }
            if (whichComputerPawn == 7 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB7);
            }
            if (whichComputerPawn == 8 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB8);
            }
            if (whichComputerPawn == 8 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB8);
            }
            if (whichComputerPawn == 9 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB9);
            }
            if (whichComputerPawn == 9 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB9);
            }
            if (whichComputerPawn == 10 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB10);
            }
            if (whichComputerPawn == 10 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB10);
            }

            if (whichComputerPawn == 11 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB11);
            }
            if (whichComputerPawn == 11 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB11);
            }
            if (whichComputerPawn == 12 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB12);
            }
            if (whichComputerPawn == 12 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB12);
            }
        });

        buttonW12.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW12);
        });

        buttonW12.setOnMouseReleased(event -> {
            mouseMovedReleased(event, grid, buttonW12,false);
            moveComputerRandom();
            System.out.println("ComputerPawn   " + whichComputerPawn + " ComputerLeftRight  "  + moveComputerLeftRight );
            if (whichComputerPawn == 1 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB1);
            }
            if (whichComputerPawn == 1 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB1);
            }
            if (whichComputerPawn == 2 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB2);
            }
            if (whichComputerPawn == 2 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB2);
            }
            if (whichComputerPawn == 3 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB3);
            }
            if (whichComputerPawn == 3 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB3);
            }
            if (whichComputerPawn == 4 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB4);
            }
            if (whichComputerPawn == 4 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB4);
            }
            if (whichComputerPawn == 5 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB5);
            }
            if (whichComputerPawn == 5 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB5);
            }
            if (whichComputerPawn == 6 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB6);
            }
            if (whichComputerPawn == 6 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB6);
            }
            if (whichComputerPawn == 7 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB7);
            }
            if (whichComputerPawn == 7 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB7);
            }
            if (whichComputerPawn == 8 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB8);
            }
            if (whichComputerPawn == 8 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB8);
            }
            if (whichComputerPawn == 9 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB9);
            }
            if (whichComputerPawn == 9 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB9);
            }
            if (whichComputerPawn == 10 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB10);
            }
            if (whichComputerPawn == 10 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB10);
            }

            if (whichComputerPawn == 11 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB11);
            }
            if (whichComputerPawn == 11 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB11);
            }
            if (whichComputerPawn == 12 && moveComputerLeftRight == 0){
                moveComputerLeft(grid, buttonB12);
            }
            if (whichComputerPawn == 12 && moveComputerLeftRight == 1){
                moveComputerRight(grid, buttonB12);
            }

        });


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
        primaryStage.show();

    }

    public void makeMove(Event even, boolean isBlackPawn) {


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

        //whichComputerPawn = 9;
        //moveComputerLeftRight = 0;

        if (isMoveBlack) {
            Random random = new Random();

           whichComputerPawn = random.nextInt(12)+1;
           moveComputerLeftRight = random.nextInt(2);

        }
    }

    public void moveComputerLeft(GridPane grid, Button button) {

        whichColumnComputer = (int) button.getLayoutX() / 60;
        whichRowComputer = (int) button.getLayoutY() / 60;

        Node isEmptyLeft = getNodeFromGridPane(grid, whichColumnComputer - 1, whichRowComputer + 1);

            if (isEmptyLeft == null && whichColumnComputer - 1 <= 8 && whichRowComputer + 1 <= 8
                && whichColumnComputer - 1 > 0 && whichRowComputer + 1 > 0) {
                grid.getChildren().remove(button);
                grid.add(button, whichColumnComputer - 1, whichRowComputer + 1);
            }


}

    public void moveComputerRight(GridPane grid, Button button) {

        whichColumnComputer = (int) button.getLayoutX() / 60;
        whichRowComputer = (int) button.getLayoutY() / 60;

        Node isEmptyRight = getNodeFromGridPane(grid, whichColumnComputer + 1, whichRowComputer + 1);

        if (isEmptyRight == null && whichColumnComputer + 1 <= 8 && whichRowComputer + 1 <= 8
                && whichColumnComputer + 1 > 0 && whichRowComputer + 1 > 0) {
            grid.getChildren().remove(button);
            grid.add(button, whichColumnComputer + 1, whichRowComputer + 1);
        }
    }

    public void moveComputer(GridPane grid, Button button) {
        if (whichComputerPawn == 1 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 1 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 2 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 2 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 3 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 3 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 4 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 4 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 5 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 5 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 6 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 6 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 7 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 7 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 8 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 8 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 9 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 9 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 10 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 10 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }

        if (whichComputerPawn == 11 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 11 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }
        if (whichComputerPawn == 12 && moveComputerLeftRight == 0){
            moveComputerLeft(grid, button);
        }
        if (whichComputerPawn == 12 && moveComputerLeftRight == 1){
            moveComputerRight(grid, button);
        }


    }


    Button button = new Button();
    public void mouseMoved(MouseEvent event) {
        double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;


    }

    public void mouseMovedReleased(MouseEvent event,GridPane grid, Button button, boolean isBlackPawn) {

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


        }
        else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
            grid.getChildren().remove(button);
            grid.add(button,column,row);
        }

        else  {
            grid.getChildren().remove(button);
            grid.add(button,column,row);

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

    public void setGraphicsBlack(Button button) {
        button.setMaxSize(50, 50);
        button.setGraphic(new ImageView(imageBlackPawnB));
        button.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
    }

    public void setGraphicsWhite(Button button) {
        button.setMaxSize(50, 50);
        button.setGraphic(new ImageView(imageBlackPawnW));
        button.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
    }

    private Node getNodeFromGridPane(GridPane grid, int col, int row) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {

                return node;
            }
        }
        return null;
    }
    private void buttonSetAction(Button button, GridPane grid) {
       // button.setOnAction((e) -> {
        //    makeMove(e, true);
       // });
        button.setOnMousePressed((event) -> {
            mouseMovedPressed(event, button);
        });

        button.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, button,true);
        });

    }

}
