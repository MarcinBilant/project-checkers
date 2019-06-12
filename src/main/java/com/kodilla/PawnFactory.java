package com.kodilla;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PawnFactory {

    private static Image imageBlackPawnB = new Image("images/black_pawn.png");
    private static Image imageBlackPawnW = new Image("images/white_pawn.png");

    public static Button createButton(boolean isBlack) {

        Button button = new Button();
        if (isBlack) {
            setGraphicsBlack(button);
        }
        else {
            setGraphicsWhite(button);
        }
        return button;
    }

    private static void setGraphicsBlack(Button button) {
        button.setMaxSize(50, 50);
        button.setGraphic(new ImageView(imageBlackPawnB));
        button.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
    }

    private static void setGraphicsWhite(Button button) {
        button.setMaxSize(50, 50);
        button.setGraphic(new ImageView(imageBlackPawnW));
        button.setStyle("-fx-border-color:rgba(0%, 0%, 100%, 0); -fx-background-color: rgba(0%, 0%, 100%, 0)");
    }

    public static List<Button> createButtons(int count, boolean isBlack) {
        return IntStream.range(0,count).mapToObj(v-> createButton(isBlack)).collect(Collectors.toList());


    }

}

