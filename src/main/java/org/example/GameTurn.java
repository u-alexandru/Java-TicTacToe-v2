package org.example;

import org.example.Interface.Board;
import org.example.Interface.Turn;

import java.util.Scanner;

public class GameTurn implements Turn {
    private final Board gameBoard;

    GameTurn(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    private void incorrectMove(Pieces piece) {
        System.out.println("Incorrect move.");
        playerMove(piece);
    }

    @Override
    public void playerMove(Pieces piece) {
        System.out.println("Type your desired move. Row + Column Ex. 1A");
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine();

        if(playerInput.length() != 2) {
            incorrectMove(piece);
            return;
        }

        int row = Character.getNumericValue(playerInput.charAt(0));
        char column = Character.toLowerCase(playerInput.charAt(1));

        if(row > 3 || row < 1) {
            incorrectMove(piece);
            return;
        }

        if(column != 'a' && column != 'b' && column != 'c') {
            incorrectMove(piece);
            return;
        }

        if(gameBoard.checkTileEmpty(row, column)) {
            gameBoard.placePieceOnBoard(piece, row, column - 96);
            gameBoard.drawBoard();
        } else {
            incorrectMove(piece);
        }
    }

    @Override
    public void AIMove(Pieces piece) {

    }
}
