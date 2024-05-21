package org.example.Interface;

import org.example.Pieces;

public interface Board {

    void drawBoard();
    Pieces[][] getBoard();
    void placePieceOnBoard(Pieces piece, int row, int column);
    Boolean checkWinState(Board board, Pieces piece);
    Boolean checkWinState(Pieces piece);
    void checkDrawState(Board board);
    void checkDrawState();
}
