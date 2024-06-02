package org.example;

import org.example.Interface.Board;

import java.security.InvalidParameterException;

public class GameBoard implements Board {

    private Pieces[][] board = {
            {Pieces.EMPTY, Pieces.EMPTY, Pieces.EMPTY},
            {Pieces.EMPTY, Pieces.EMPTY, Pieces.EMPTY},
            {Pieces.EMPTY, Pieces.EMPTY, Pieces.EMPTY}
    };

    @Override
    public void drawBoard() {
        // Print column numbers for reference
        System.out.println("    A   B   C");

        for (int i = 0; i < board.length; i++) {
            // Print the row separator
            if (i == 0) {
                System.out.println("  ╔═══╦═══╦═══╗");
            } else {
                System.out.println("  ╠═══╬═══╬═══╣");
            }

            // Print row number and the contents of each row
            System.out.print((i + 1) + " ");
            for (int j = 0; j < board[i].length; j++) {
                char pieceInTile = ' ';
                if (board[i][j] == Pieces.CROSS) {
                    pieceInTile = 'X';
                } else if (board[i][j] == Pieces.CIRCLE) {
                    pieceInTile = 'O';
                }

                if (j == 0) {
                    System.out.print("║ " + pieceInTile + " ");
                } else {
                    System.out.print("│ " + pieceInTile + " ");
                }
            }
            System.out.println("║");
        }

        // Print the final row separator
        System.out.println("  ╚═══╩═══╩═══╝");
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
    public Boolean checkTileEmpty(int row, char column) throws InvalidParameterException {
        char lowerCaseColumn = Character.toLowerCase(column);

        if(row > 3 || row < 1) {
            throw new InvalidParameterException("Invalid parameter passed");
        }

        return switch (lowerCaseColumn) {
            case 'a' -> this.board[row - 1][0] == Pieces.EMPTY;
            case 'b' -> this.board[row - 1][1] == Pieces.EMPTY;
            case 'c' -> this.board[row - 1][2] == Pieces.EMPTY;
            default -> throw new InvalidParameterException("Invalid parameter passed");
        };
    }

    @Override
    public Boolean checkWinState(Pieces[][] boardArray, Pieces piece) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (boardArray[i][0] == piece && boardArray[i][1] == piece && boardArray[i][2] == piece) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (boardArray[0][i] == piece && boardArray[1][i] == piece && boardArray[2][i] == piece) {
                return true;
            }
        }

        // Check diagonals
        if (boardArray[0][0] == piece && boardArray[1][1] == piece && boardArray[2][2] == piece) {
            return true;
        }
        if (boardArray[0][2] == piece && boardArray[1][1] == piece && boardArray[2][0] == piece) {
            return true;
        }

        // No win state
        return false;
    }

    @Override
    public Boolean checkWinState(Pieces piece) {
        Pieces[][] boardArray = this.board;
        return checkWinState(boardArray, piece);
    }

    @Override
    public Boolean checkDrawState(Board board) {
        Pieces[][] boardArray = board.getBoard();
        for (Pieces[] row : boardArray) {
            for (Pieces tile : row) {
                if (tile == Pieces.EMPTY) {
                    return false;
                }
            }
        }
        // If all tiles are filled, check if there's a win state
        return !checkWinState(boardArray, Pieces.CROSS) && !checkWinState(boardArray, Pieces.CIRCLE);
    }

    @Override
    public Boolean checkDrawState() {
        for (Pieces[] row : this.board) {
            for (Pieces tile : row) {
                if (tile == Pieces.EMPTY) {
                    return false;
                }
            }
        }
        // If all tiles are filled, check if there's a win state
        return !checkWinState(this.board, Pieces.CROSS) && !checkWinState(this.board, Pieces.CIRCLE);
    }
}
