
import com.kodilla.ButtonParameters;
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

        Button buttonB1 = new Button();
        buttonB1.setMaxSize(50, 50);
        buttonB1.setGraphic(new ImageView(imageBlackPawnB));
        buttonB1.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB1.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB1.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB1,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB1);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB1.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB1, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB1,column,row);
            }

            else  {
                grid.add(buttonB1,column,row);

            }
        });

        Button buttonB2 = new Button();
        buttonB2.setMaxSize(50, 50);
        buttonB2.setGraphic(new ImageView(imageBlackPawnB));
        buttonB2.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB2.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB2.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB2,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB2);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB2.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB2, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB2,column,row);
            }

            else  {
                grid.add(buttonB2,column,row);

            }
        });

        Button buttonB3 = new Button();
        buttonB3.setMaxSize(50, 50);
        buttonB3.setGraphic(new ImageView(imageBlackPawnB));
        buttonB3.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB3.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB3.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB3,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB3);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB3.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB3, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB3,column,row);
            }

            else  {
                grid.add(buttonB3,column,row);

            }
        });

        Button buttonB4 = new Button();
        buttonB4.setMaxSize(50, 50);
        buttonB4.setGraphic(new ImageView(imageBlackPawnB));
        buttonB4.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB1.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB4.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB4,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB4);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB4.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB4, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB4,column,row);
            }

            else  {
                grid.add(buttonB4,column,row);

            }
        });

        Button buttonB5 = new Button();
        buttonB5.setMaxSize(50, 50);
        buttonB5.setGraphic(new ImageView(imageBlackPawnB));
        buttonB5.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB5.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB5.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB5,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB5);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB5.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB5, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB5,column,row);
            }

            else  {
                grid.add(buttonB5,column,row);

            }
        });

        Button buttonB6 = new Button();
        buttonB6.setMaxSize(50, 50);
        buttonB6.setGraphic(new ImageView(imageBlackPawnB));
        buttonB6.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB6.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB6.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB6,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB6);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB6.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB6, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB6,column,row);
            }

            else  {
                grid.add(buttonB6,column,row);

            }
        });

        Button buttonB7 = new Button();
        buttonB7.setMaxSize(50, 50);
        buttonB7.setGraphic(new ImageView(imageBlackPawnB));
        buttonB7.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB7.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB7.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB7,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB7);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB7.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB7, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB7,column,row);
            }

            else  {
                grid.add(buttonB7,column,row);

            }
        });

        Button buttonB8 = new Button();
        buttonB8.setMaxSize(50, 50);
        buttonB8.setGraphic(new ImageView(imageBlackPawnB));
        buttonB8.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB8.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB8.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB8,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB8);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB8.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB8, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB8,column,row);
            }

            else  {
                grid.add(buttonB8,column,row);

            }
        });

        Button buttonB9 = new Button();
        buttonB9.setMaxSize(50, 50);
        buttonB9.setGraphic(new ImageView(imageBlackPawnB));
        buttonB9.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB9.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB9.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB9,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB9);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB9.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB9, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB9,column,row);
            }

            else  {
                grid.add(buttonB9,column,row);

            }
        });

        Button buttonB10 = new Button();
        buttonB10.setMaxSize(50, 50);
        buttonB10.setGraphic(new ImageView(imageBlackPawnB));
        buttonB10.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB10.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB10.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB10,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB10);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB10.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB10, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB10,column,row);
            }

            else  {
                grid.add(buttonB10,column,row);

            }
        });

        Button buttonB11 = new Button();
        buttonB11.setMaxSize(50, 50);
        buttonB11.setGraphic(new ImageView(imageBlackPawnB));
        buttonB11.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB11.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB11.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB11,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB11);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB11.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB11, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB11,column,row);
            }

            else  {
                grid.add(buttonB11,column,row);

            }
        });

        Button buttonB12 = new Button();
        buttonB12.setMaxSize(50, 50);
        buttonB12.setGraphic(new ImageView(imageBlackPawnB));
        buttonB12.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonB12.setOnAction((e) -> {
            makeMove(e, true);
        });
        buttonB12.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonB12,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonB12);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonB12.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonB12, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonB12,column,row);
            }

            else  {
                grid.add(buttonB12,column,row);

            }
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
        buttonW1.setMaxSize(50, 50);
        buttonW1.setGraphic(new ImageView(imageBlackPawnW));
        buttonW1.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW1.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW1.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW1,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW1);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW1.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW1, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW1,column,row);
            }

            else  {
                grid.add(buttonW1,column,row);

            }
        });

        Button buttonW2 = new Button();
        buttonW2.setMaxSize(50, 50);
        buttonW2.setGraphic(new ImageView(imageBlackPawnW));
        buttonW2.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW2.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW2.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW2,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW2);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW2.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW2, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW2,column,row);
            }

            else  {
                grid.add(buttonW2,column,row);

            }
        });

        Button buttonW3 = new Button();
        buttonW3.setMaxSize(50, 50);
        buttonW3.setGraphic(new ImageView(imageBlackPawnW));
        buttonW3.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW3.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW3.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW3,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW3);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW3.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW3, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW3,column,row);
            }

            else  {
                grid.add(buttonW3,column,row);

            }
        });

        Button buttonW4 = new Button();
        buttonW4.setMaxSize(50, 50);
        buttonW4.setGraphic(new ImageView(imageBlackPawnW));
        buttonW4.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW4.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW4.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW4,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW4);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW4.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW4, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW4,column,row);
            }

            else  {
                grid.add(buttonW4,column,row);

            }
        });

        Button buttonW5 = new Button();
        buttonW5.setMaxSize(50, 50);
        buttonW5.setGraphic(new ImageView(imageBlackPawnW));
        buttonW5.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW5.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW5.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW5,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW5);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW5.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW5, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW5,column,row);
            }

            else  {
                grid.add(buttonW5,column,row);

            }
        });

        Button buttonW6 = new Button();
        buttonW6.setMaxSize(50, 50);
        buttonW6.setGraphic(new ImageView(imageBlackPawnW));
        buttonW6.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW6.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW6.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW6,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW6);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW6.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW6, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW6,column,row);
            }

            else  {
                grid.add(buttonW6,column,row);

            }
        });

        Button buttonW7 = new Button();
        buttonW7.setMaxSize(50, 50);
        buttonW7.setGraphic(new ImageView(imageBlackPawnW));
        buttonW7.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW7.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW7.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW7,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW7);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW7.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW7, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW7,column,row);
            }

            else  {
                grid.add(buttonW7,column,row);

            }
        });

        Button buttonW8 = new Button();
        buttonW8.setMaxSize(50, 50);
        buttonW8.setGraphic(new ImageView(imageBlackPawnW));
        buttonW8.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW8.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW8.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW8,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW8);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW8.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW8, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW8,column,row);
            }

            else  {
                grid.add(buttonW8,column,row);

            }
        });

        Button buttonW9 = new Button();
        buttonW9.setMaxSize(50, 50);
        buttonW9.setGraphic(new ImageView(imageBlackPawnW));
        buttonW9.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW9.setOnAction((e) -> {
            makeMove(e, false);
        });
        buttonW9.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW9,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW9);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW9.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW9, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW9,column,row);
            }

            else  {
                grid.add(buttonW9,column,row);

            }
        });

        Button buttonW10 = new Button();
        buttonW10.setMaxSize(50, 50);
        buttonW10.setGraphic(new ImageView(imageBlackPawnW));
        buttonW10.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW10.setOnAction((e) -> {
            makeMove(e, false);
        });

        buttonW10.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW10,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW10);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW10.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW10, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW10,column,row);
            }

            else  {
                grid.add(buttonW10,column,row);

            }
        });

        Button buttonW11 = new Button();
        buttonW11.setMaxSize(50, 50);
        buttonW11.setGraphic(new ImageView(imageBlackPawnW));
        buttonW11.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW11.setOnAction((e) -> {
            makeMove(e, false);
        });

        buttonW11.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW11,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW11);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW11.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW11, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW11,column,row);
            }

            else  {
                grid.add(buttonW11,column,row);

            }
        });

        Button buttonW12 = new Button();
        buttonW12.setMaxSize(50, 50);
        buttonW12.setGraphic(new ImageView(imageBlackPawnW));
        buttonW12.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
        buttonW12.setOnAction((e) -> {
            makeMove(e, false);
        });

        buttonW12.setOnMousePressed((event )->  {
            mouseMoved(event);
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn,whichRow);
            HashMap<Button,ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(buttonW12,buttonParameters);
            ButtonParameters parameters = buttonParametersHashMap.get(buttonW12);
            column = parameters.getColumn();
            row = parameters.getRow();

        });

        buttonW12.setOnMouseReleased((event) -> {
            mouseMoved(event);
            Node isEmpty = getNodeFromGridPane(grid,whichColumn,whichRow);
            if (isEmpty == null && whichColumn <=8 && whichRow <=8 && whichColumn >0 && whichRow >0) {
                grid.add(buttonW12, whichColumn, whichRow);
            }
            else if (isEmpty == null && whichColumn >=8 && whichRow >=8) {
                grid.add(buttonW12,column,row);
            }

            else  {
                grid.add(buttonW12,column,row);

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
            System.out.println("Wykonuję ruch białymi");

            isMoveBlack = true;
        } else if (isBlackPawn && isMoveBlack) {
            System.out.println("Wykonuje ruch czarnymi");
            isMoveBlack = false;
        } else {
            System.out.println("Błędny pionek");
        }
    }

    public void mouseMoved(MouseEvent event) {
        double sceneX;
        double sceneY;
        sceneX = event.getSceneX();
        sceneY = event.getSceneY();
        whichColumn = (int) sceneX / 60;
        whichRow = (int) sceneY / 60;
    }

    private Node getNodeFromGridPane(GridPane grid, int col, int row) {
        for (Node node : grid.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

}
