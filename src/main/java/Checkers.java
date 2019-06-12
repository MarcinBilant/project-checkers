
import com.kodilla.ButtonParameters;
import com.kodilla.PawnFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
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


        //grid.getColumnConstraints().add(new ColumnConstraints(120));
        //grid.getRowConstraints().add(new RowConstraints(120));
        List<Button> blackButtons = PawnFactory.createButtons(12,true);
        List<Button> whiteButtons = PawnFactory.createButtons(12,false);
        blackButtons.forEach(button-> buttonSetAction(button, grid));
        whiteButtons.forEach(button-> buttonSetAction(button, grid));


        Button buttonB1 = new Button();
        setGraphicsBlack(buttonB1);
        buttonB1.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB1.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB1);
        });

        buttonB1.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB1);
        });

        Button buttonB2 = new Button();
        setGraphicsBlack(buttonB2);
        buttonB2.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB2.setOnMousePressed((event) -> {

            mouseMovedPressed(event, buttonB2);
        });

        buttonB2.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB2);
        });

        Button buttonB3 = new Button();
        setGraphicsBlack(buttonB3);
        buttonB3.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB3.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB3);
        });

        buttonB3.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB3);
        });

        Button buttonB4 = new Button();
        setGraphicsBlack(buttonB4);
        buttonB1.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB4.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB4);
        });

        buttonB4.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB4);
        });

        Button buttonB5 = new Button();
        setGraphicsBlack(buttonB5);
        buttonB5.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB1);
        });

        buttonB5.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB5);
        });

        Button buttonB6 = new Button();
        setGraphicsBlack(buttonB6);
        buttonB6.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB6.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB6);

        });

        buttonB6.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB6);
        });

        Button buttonB7 = new Button();
        setGraphicsBlack(buttonB7);
        buttonB7.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB7.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB7);
        });

        buttonB7.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB7);
        });

        Button buttonB8 = new Button();
        setGraphicsBlack(buttonB8);
        buttonB8.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB8.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB8);
        });

        buttonB8.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB8);
        });

        Button buttonB9 = new Button();
        setGraphicsBlack(buttonB9);
        buttonB9.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB9.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB9);
        });

        buttonB9.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB9);
        });

        Button buttonB10 = new Button();
        setGraphicsBlack(buttonB10);
        buttonB10.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB10.setOnMousePressed((event) -> {

            mouseMovedPressed(event, buttonB10);

        });

        buttonB10.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB10);
        });

        Button buttonB11 = new Button();
        setGraphicsBlack(buttonB11);
        buttonB11.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB11.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB11);

        });

        buttonB11.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB11);
        });

        Button buttonB12 = new Button();
        setGraphicsBlack(buttonB12);
        buttonB12.setOnAction((e) -> {
            makeMove(e, true);
        });

        buttonB12.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonB12);
        });

        buttonB12.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonB12);
        });

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

        Button buttonW1 = new Button();
        setGraphicsWhite(buttonW1);
        buttonW1.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW1.setOnMousePressed((event) -> {

            mouseMovedPressed(event, buttonW1);
        });

        buttonW1.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW1);
        });

        Button buttonW2 = new Button();
        setGraphicsWhite(buttonW2);
        buttonW2.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW2.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW2);
        });

        buttonW2.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW2);
        });

        Button buttonW3 = new Button();
        setGraphicsWhite(buttonW3);
        buttonW3.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW3.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW3);
        });

        buttonW3.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW3);
        });

        Button buttonW4 = new Button();
        setGraphicsWhite(buttonW4);
        buttonW4.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW4.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW4);
        });

        buttonW4.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW4);
        });

        Button buttonW5 = new Button();
        setGraphicsWhite(buttonW5);
        buttonW5.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW5.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW5);
        });

        buttonW5.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW5);
        });

        Button buttonW6 = new Button();
        setGraphicsWhite(buttonW6);
        buttonW6.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW6.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW6);

        });

        buttonW6.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW6);
        });

        Button buttonW7 = new Button();
        setGraphicsWhite(buttonW7);
        buttonW7.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW7.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW7);
        });

        buttonW7.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW7);
        });

        Button buttonW8 = new Button();
        setGraphicsWhite(buttonW8);
        buttonW8.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW8.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW8);
        });

        buttonW8.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW8);
        });

        Button buttonW9 = new Button();
        setGraphicsWhite(buttonW9);
        buttonW9.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW9.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW9);
        });

        buttonW9.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW9);
        });

        Button buttonW10 = new Button();
        setGraphicsWhite(buttonW10);
        buttonW10.setOnAction((e) -> {
            makeMove(e, false);
        });

        buttonW10.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW10);
        });

        buttonW10.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW10);
        });

        Button buttonW11 = new Button();
        setGraphicsWhite(buttonW11);
        buttonW11.setOnAction((e) -> {
            makeMove(e, false);
        });

        buttonW11.setOnMousePressed((event) -> {
            mouseMovedPressed(event, buttonW11);
        });

        buttonW11.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, buttonW11);
        });

        Button buttonW12 = new Button();
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
            mouseMovedReleased(event, grid, buttonW12);
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

    public void makeMove(ActionEvent e, boolean isBlackPawn) {


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


    Button button = new Button();
    public void mouseMoved(MouseEvent event) {
        double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;


    }

    public void mouseMovedReleased(MouseEvent event,GridPane grid, Button button) {

        double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;

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
        button.setOnAction((e) -> {
            makeMove(e, true);
        });
        button.setOnMousePressed((event) -> {
            mouseMovedPressed(event, button);
        });

        button.setOnMouseReleased((event) -> {
            mouseMovedReleased(event, grid, button);
        });

    }

}
