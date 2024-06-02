package org.example;

import org.example.Interface.Board;
import org.example.Interface.Turn;

import java.util.Scanner;

public class Game {
    private Pieces playerPiece = Pieces.CROSS;
    private final Scanner scanner = new Scanner(System.in);
    private final Turn gameTurn;
    private final Board gameBoard;
    private Pieces nextToMove = Pieces.CROSS;
    private Pieces aiPiece = Pieces.CIRCLE;

    Game(Turn gameTurn, Board gameBoard) {
        this.gameTurn = gameTurn;
        this.gameBoard = gameBoard;
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
            aiPiece = Pieces.CIRCLE;
        } else if(Character.toLowerCase(userAnswer.charAt(0)) == 'n') {
            playerPiece = Pieces.CIRCLE;
            aiPiece = Pieces.CROSS;
        } else {
            chosePlayingOrder();
        }
    }

    public void startGame() {
        chosePlayingOrder();
        update();
    }

    public void update() {
        if(playerPiece == nextToMove) {
            gameTurn.playerMove(playerPiece);
            nextToMove = aiPiece;
        } else {
            gameTurn.AIMove(aiPiece);
            nextToMove = playerPiece;
        }
        update();
    }
}
