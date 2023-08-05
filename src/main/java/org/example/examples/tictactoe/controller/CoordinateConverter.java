package org.example.examples.tictactoe.controller;

import org.example.board.Coordinate;
import org.example.examples.tictactoe.model.TicTacToeBaseBoard;

public class CoordinateConverter {
    private final TicTacToeBaseBoard board;
    private final char startChar;

    public CoordinateConverter(TicTacToeBaseBoard board, char startChar) {
        this.board = board;
        this.startChar = startChar;
    }

    public char coordinateToChar(Coordinate coordinate) {
        return  (char) (startChar + coordinate.row * board.columns() + coordinate.column);
    }

    public Coordinate charToCoordinate(char ch) {
        int number = ch - startChar;
        int row = number / board.rows();
        int column = number % board.columns();
        return new Coordinate(row, column);
    }
}
