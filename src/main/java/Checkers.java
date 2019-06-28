import com.kodilla.ButtonParameters;
import com.kodilla.MoveResult;
import com.kodilla.PawnFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Checkers extends Application {


    private List<Button> blackButtons = PawnFactory.createButtons(12, true);
    private List<Button> whiteButtons = PawnFactory.createButtons(12, false);

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
    private String name;
    private String surname;


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



            //Scene scene1 = new Scene (vBox, 960, 600);


            for (int i = 0; i < 10; i++) {
                ColumnConstraints column = new ColumnConstraints(60);
                grid.getColumnConstraints().add(column);
            }


            for (int i = 0; i < 10; i++) {
                RowConstraints row = new RowConstraints(60);
                grid.getRowConstraints().add(row);
            }


            //grid.getColumnConstraints().add(new ColumnConstraints(120));
            //grid.getRowConstraints().add(new RowConstraints(120));
            VBox daneVbox = new VBox();


            Label playerData = new Label("Wpisz dane gracza");
            playerData.setStyle("-fx-text-fill: white");

            Label playerName = new Label("Imie");
            playerName.setStyle("-fx-text-fill: white");

            TextField nameField = new TextField();

            Label playerSurname = new Label("Nazwisko");
            playerSurname.setStyle("-fx-text-fill: white");

            TextField surnameField = new TextField();


            Button save = new Button("Zapisz");
            Button reset = new Button("Reset");

            save.setOnAction((e) -> {
                name = nameField.getText();
                surname = surnameField.getText();
                nameField.setDisable(true);
                surnameField.setDisable(true);
                nameField.setStyle("-fx-opacity: 1;");
                surnameField.setStyle("-fx-opacity: 1;");
                });

            reset.setOnAction((e) -> {
                nameField.setText("");
                surnameField.setText("");
                nameField.setDisable(false);
                surnameField.setDisable(false);
            });



            MenuBar menuBar = new MenuBar ();
            Menu menu1 = new Menu("Opis");

            MenuItem menuItem1 = new MenuItem("Zasady gry");

            menu1.getItems().add(menuItem1);


            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("files/rulesOfGames2.txt").getFile());
            Path path = Paths.get(file.getPath());
            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);

            menu1.setOnAction((e) -> {

                GridPane gridRules = new GridPane();
                TextArea rulesText = new TextArea();
                rulesText.setWrapText(true);
                rulesText.setEditable(false);
                //rulesText.setText(fileLines);
                rulesText.setText("Gra warcaby klasyczne (określana też warcabami brazylijskimi) jest rozgrywana na planszy 8x8 pól pokolorowanych na przemian na kolor jasny i ciemny.\n" +
                        "Każdy gracz rozpoczyna grę z dwunastoma pionami (jeden koloru białego, drugi -- czerwonego) ustawionymi na ciemniejszych polach planszy.\n" +
                        "Jako pierwszy ruch wykonuje grający pionami białymi, po czym gracze wykonują na zmianę kolejne ruchy.\n" +
                        "Celem gry jest zbicie wszystkich pionów przeciwnika (w tym damek -- patrz niżej) albo zablokowanie wszystkich, które pozostają na planszy, pozbawiając przeciwnika możliwości wykonania ruchu. Jeśli żaden z graczy nie jest w stanie tego osiągnąć (każdy z graczy wykona po 15 ruchów damkami bez zmniejszania liczby pionów pozostających na planszy), następuje remis.\n" +
                        "Piony mogą poruszać się o jedno pole do przodu po przekątnej (na ukos) na wolne pola.\n" +
                        "Bicie pionem następuje przez przeskoczenie sąsiedniego pionu (lub damki) przeciwnika na pole znajdujące się tuż za nim po przekątnej (pole to musi być wolne). Zbite piony są usuwane z planszy po zakończeniu ruchu.\n" +
                        "Piony mogą bić zarówno do przodu, jak i do tyłu.\n" +
                        "W jednym ruchu wolno wykonać więcej niż jedno bicie tym samym pionem, przeskakując przez kolejne piony (damki) przeciwnika.\n" +
                        "Bicia są obowiązkowe.\n" +
                        "Pion, który dojdzie do ostatniego rzędu planszy, staje się damką, przy czym jeśli znajdzie się tam w wyniku bicia i będzie mógł wykonać kolejne bicie (do tyłu), to będzie musiał je wykonać i nie staje się wtedy damką.\n" +
                        "Kiedy pion staje się damką, kolej ruchu przypada dla przeciwnika.\n" +
                        "Damki mogą poruszać się w jednym ruchu o dowolną liczbę pól do przodu lub do tyłu po przekątnej, zatrzymując się na wolnych polach.\n" +
                        "Bicie damką jest możliwe z dowolnej odległości po linii przekątnej i następuje przez przeskoczenie pionu (lub damki) przeciwnika, za którym musi znajdować się co najmniej jedno wolne pole -- damka przeskakuje na dowolne z tych pól i może kontynuować bicie (na tej samej lub prostopadłej linii).\n" +
                        "Kiedy istnieje kilka możliwych bić, gracz musi wykonać maksymalne (tzn. takie, w którym zbije największą liczbę pionów lub damek przeciwnika).\n" +
                        "Podczas bicia nie można przeskakiwać więcej niż raz przez ten sam pion (damkę).\n" +
                        "Istnieje opcja gry (tzw. latająca warcaba, mini-mecze), w której początkowe ustawienie pionów jest lekko modyfikowane według specjalnej tabeli i rozgrywa się dwa mecze - ze zmianą kolorów.\n" +
                        "\n");
                //rulesText.getText(fileLines.forEach(System.out::println));

                Scene sceneRules = new Scene(rulesText,600, 600, Color.BLACK);
                Stage secondStage = new Stage();
                secondStage.setTitle("Zasady gry");
                secondStage.setScene(sceneRules);
                secondStage.show();

            });



            menuBar.getMenus().add(menu1);
            VBox vBoxMenu = new VBox (menuBar);
            grid.add(vBoxMenu,0,0);

            daneVbox.setAlignment(Pos.CENTER);
            daneVbox.getChildren().addAll(playerData,playerName,nameField,playerSurname,surnameField);
            HBox buttonHbox = new HBox(10);
            buttonHbox.setPadding(new Insets(0, 10, 0, 10));
            buttonHbox.getChildren().addAll(save,reset);

            grid.add(daneVbox,10,1);
            grid.add(buttonHbox,10,3);



            blackButtons.forEach(button -> buttonSetActionBlack(button, grid, true));
            whiteButtons.forEach(button -> buttonSetActionWhite(button, grid, false));


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
            //Scene scene1 = new Scene (vBox, 960, 600);
            //Scene scene1 = new Scene();


            primaryStage.setTitle("Checkers");
            primaryStage.setScene(scene);
            //primaryStage.setScene(scene1);
            //primaryStage.setResizable(false);
            primaryStage.show();

        }

        private void computerMove(GridPane grid) {
            makeMove(false);

            boolean correctMove = false;

            if (!noMovePawn) {

                do {
                    correctMove = checkIsKillPossibleAndKillBeforeMove(grid);
                    moveComputerRandom();
                    if (moveComputerLeftRight == 0) {
                        correctMove = moveComputerLeft(grid, blackButtons.get(whichComputerPawn - 1));
                    } else {
                        correctMove = moveComputerRight(grid, blackButtons.get(whichComputerPawn - 1));
                    }
                } while (!correctMove);
            }
        }

        private boolean checkIsKillPossibleAndKillBeforeMove(GridPane grid) {
            boolean isPossibleKill = false;
            for (int i = 0; i < blackButtons.size(); i++) {

                Node isFirstEmptyLeft = getNodeFromGridPane(grid, whichColumnComputer - 1, whichRowComputer + 1);
                Node isSecondEmptyLeft = getNodeFromGridPane(grid, whichColumnComputer - 2, whichRowComputer + 2);

                Button pown = (Button) isFirstEmptyLeft;

                if (isFirstEmptyLeft != null && isSecondEmptyLeft == null && whiteButtons.contains(pown)) {
                    System.out.println("BICIE!");
                    isPossibleKill = true;
                    break;
                }
            }

            return false;
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

                whichComputerPawn = random.nextInt(12) + 1;
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

                checkIsKillPossibleAndKill(whichColumnComputer, whichRowComputer, grid, button);

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

                checkIsKillPossibleAndKill(whichColumnComputer, whichRowComputer, grid, button);

                return true;
            }
            return false;
        }

        private void checkIsKillPossibleAndKill(int whichColumnComputer, int whichRowComputer, GridPane grid, Button button) {
            Node isFirstEmptyLeft = getNodeFromGridPane(grid, whichColumnComputer - 1, whichRowComputer + 1);
            Node isSecondEmptyLeft = getNodeFromGridPane(grid, whichColumnComputer - 2, whichRowComputer + 2);

            Button pown = (Button) isFirstEmptyLeft;

            if (isFirstEmptyLeft != null && isSecondEmptyLeft == null && whiteButtons.contains(pown)) {
                System.out.println("BICIE!");
            }

        }


        public boolean mouseMovedReleased(MouseEvent event, GridPane grid, Button button, boolean isBlackPawn) {

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

            Node isEmpty = getNodeFromGridPane(grid, whichColumn, whichRow);
            if (isEmpty == null && whichColumn <= 8 && whichRow <= 8 && whichColumn > 0 && whichRow > 0) {
                grid.getChildren().remove(button);
                grid.add(button, whichColumn, whichRow);
                //grid.add(button,whichColumn+1,whichRow+1);


            } else if (isEmpty == null && whichColumn >= 8 && whichRow >= 8) {
                grid.getChildren().remove(button);
                grid.add(button, column, row);
                return noMovePawn = true;
            } else {
                grid.getChildren().remove(button);
                grid.add(button, column, row);
                return noMovePawn = true;

            }

            if (whichColumn == column && whichRow == row) {
                return noMovePawn = true;

            } else {
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
            ButtonParameters buttonParameters = new ButtonParameters(whichColumn, whichRow);
            HashMap<Button, ButtonParameters> buttonParametersHashMap = new HashMap<>();
            buttonParametersHashMap.put(button, buttonParameters);
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
                mouseMovedReleased(event, grid, button, isBlackPawn);
                if (!isBlackPawn) {
                    computerMove(grid);
                }
            });
        }

        private void buttonSetActionBlack(Button button, GridPane grid, boolean isBlackPawn) {
            // button.setOnAction((e) -> {
            //    makeMove(true);
            // });


            button.setOnMouseEntered(event -> {
                mouseMovedEntered(event, button);
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