
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Checkers extends Application {

    private Image imageback = new Image("images/board.jpg");
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
        grid.setPadding(new Insets(0,0,0,20));
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
        buttonB1.setText("B");
        Button buttonB2 = new Button();
        buttonB2.setText("B");
        Button buttonB3 = new Button();
        buttonB3.setText("B");
        Button buttonB4 = new Button();
        buttonB4.setText("B");
        Button buttonB5 = new Button();
        buttonB5.setText("B");
        Button buttonB6 = new Button();
        buttonB6.setText("B");
        Button buttonB7 = new Button();
        buttonB7.setText("B");
        Button buttonB8 = new Button();
        buttonB8.setText("B");
        Button buttonB9 = new Button();
        buttonB9.setText("B");
        Button buttonB10 = new Button();
        buttonB10.setText("B");
        Button buttonB11 = new Button();
        buttonB11.setText("B");
        Button buttonB12 = new Button();
        buttonB12.setText("B");

        grid.add(buttonB1,1,1);
        grid.add(buttonB2,3,1);
        grid.add(buttonB3,5,1);
        grid.add(buttonB4,7,1);
        grid.add(buttonB5,2,2);
        grid.add(buttonB6,4,2);
        grid.add(buttonB7,6,2);
        grid.add(buttonB8,8,2);
        grid.add(buttonB9,1,3);
        grid.add(buttonB10,3,3);
        grid.add(buttonB11,5,3);
        grid.add(buttonB12,7,3);

        Button buttonW1 = new Button();
        buttonW1.setText("W");
        Button buttonW2 = new Button();
        buttonW2.setText("W");
        Button buttonW3 = new Button();
        buttonW3.setText("W");
        Button buttonW4 = new Button();
        buttonW4.setText("W");
        Button buttonW5 = new Button();
        buttonW5.setText("W");
        Button buttonW6 = new Button();
        buttonW6.setText("W");
        Button buttonW7 = new Button();
        buttonW7.setText("W");
        Button buttonW8 = new Button();
        buttonW8.setText("W");
        Button buttonW9 = new Button();
        buttonW9.setText("W");
        Button buttonW10 = new Button();
        buttonW10.setText("W");
        Button buttonW11 = new Button();
        buttonW11.setText("W");
        Button buttonW12 = new Button();
        buttonW12.setText("W");

        grid.add(buttonW1,2,6);
        grid.add(buttonW2,4,6);
        grid.add(buttonW3,6,6);
        grid.add(buttonW4,8,6);
        grid.add(buttonW5,1,7);
        grid.add(buttonW6,3,7);
        grid.add(buttonW7,5,7);
        grid.add(buttonW8,7,7);
        grid.add(buttonW9,2,8);
        grid.add(buttonW10,4,8);
        grid.add(buttonW11,6,8);
        grid.add(buttonW12,8,8);


        //GridPane.setHalignment(button1, HPos.CENTER);

        Scene scene = new Scene(grid, 725, 610, Color.BLACK);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
