package org.example;

import org.example.Interface.Turn;

import java.util.Scanner;

public class GameTurn implements Turn {
    private Pieces nextToMove = Pieces.CROSS;

    private void incorrectMove() {
        System.out.println("Incorrect move.");
        playerMove();
    }

    @Override
    public void playerMove() {
        System.out.println("Type your desired move. Row + Column Ex. 1A");
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine();

        if(playerInput.length() != 2) {
            incorrectMove();
            return;
        }

        int row = playerInput.charAt(0);
        char column = Character.toLowerCase(playerInput.charAt(1));

        if(row > 3 || row < 1) {
            incorrectMove();
            return;
        }

        if(column != 'a' && column != 'b' && column != 'c') {
            incorrectMove();
            return;
        }

        // TODO: Make the move

    }

    @Override
    public void AIMove() {

    }

    public void nextTurn() {

    }
}
