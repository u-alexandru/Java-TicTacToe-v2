package org.example;

import org.example.Interface.Board;

public class GameBoard implements Board {

    private Pieces[][] board = {
            {Pieces.EMPTY, Pieces.EMPTY, Pieces.EMPTY},
            {Pieces.EMPTY, Pieces.EMPTY, Pieces.EMPTY},
            {Pieces.EMPTY, Pieces.EMPTY, Pieces.EMPTY}
    };

    @Override
    public void drawBoard() {
        for(Pieces[] row : board) {
            System.out.println("_______________"); // Print the row ceiling to separate rows
            for(Pieces tile : row) {
                char pieceInTile = ' ';

                if(tile == Pieces.CROSS) { pieceInTile = 'X'; }
                if(tile == Pieces.CIRCLE) { pieceInTile = 'O'; }

                System.out.println(
                        "| " + pieceInTile + " |"
                );
            }
        }
    }

    @Override
    public Pieces[][] getBoard() {
        return this.board;
    }

    @Override
    public void placePieceOnBoard(Pieces piece, int row, int column) {
        this.board[row - 1][column - 1] = piece;
    }

    @Override
    public Boolean checkWinState(Board board, Pieces piece) {
        return null;
    }

    @Override
    public Boolean checkWinState(Pieces piece) {
        return null;
    }

    @Override
    public void checkDrawState(Board board) {

    }

    @Override
    public void checkDrawState() {

    }
}
