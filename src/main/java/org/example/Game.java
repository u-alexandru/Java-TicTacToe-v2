package org.example;

import org.example.Interface.Turn;

import java.util.Scanner;

public class Game {
    private Pieces playerPiece = Pieces.CROSS;
    private final Scanner scanner = new Scanner(System.in);
    private final Turn gameTurn;

    Game(Turn gameTurn) {
        this.gameTurn = gameTurn;
    }

    private void printText(String text) {
        System.out.println(text);
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    public void chosePlayingOrder() {
        printText("Do you want to make the first move? Y/N");
        String userAnswer = getUserInput();

        if(userAnswer.isEmpty()) {
            chosePlayingOrder();
        }

        if(Character.toLowerCase(userAnswer.charAt(0)) == 'y' ) {
            playerPiece = Pieces.CROSS;
        } else if(Character.toLowerCase(userAnswer.charAt(0)) == 'n') {
            playerPiece = Pieces.CIRCLE;
        } else {
            chosePlayingOrder();
        }
    }

    public void startGame() {
        chosePlayingOrder();
    }

    public void update() {

    }
}
