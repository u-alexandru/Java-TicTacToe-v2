package org.example;

import org.example.Interface.Board;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Board gameBoard = new GameBoard();
        Game game = new Game(new GameTurn(gameBoard), gameBoard);
        game.startGame();
    }
}