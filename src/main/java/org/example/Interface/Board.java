package org.example.Interface;

import org.example.Pieces;

public interface Board {

    void drawBoard();
    Pieces[][] getBoard();
    void placePieceOnBoard(Pieces piece, int row, int column);
    Boolean checkWinState(Pieces[][] boardArray, Pieces piece);
    Boolean checkWinState(Pieces piece);
    Boolean checkDrawState(Board board);
    Boolean checkDrawState();
    Boolean checkTileEmpty(int row, char column);
}
