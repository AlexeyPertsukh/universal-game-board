package org.example.examples.tictactoe.controller;

import org.example.board.Coordinate;
import org.example.examples.tictactoe.model.Mover;
import org.example.examples.tictactoe.model.TicTacToeBoard;

public class CoordinateConverter {
    private final static String ERROR = "illegal coordinate";
    private final TicTacToeBoard board;
    private final char startChar;

    public CoordinateConverter(TicTacToeBoard board, char startChar) {
        this.board = board;
        this.startChar = startChar;
    }

    public char coordinateToAddress(Coordinate coordinate) {
        return  (char) (startChar + coordinate.row * board.columns() + coordinate.column);
    }

    public Coordinate addressToCoordinate(String address) {

        if (address.length() != 1) {
            throw new Mover.MoverException(ERROR + ", address must be one character, but was: " + address.length());
        }
        char ch = address.charAt(0);

        int number = ch - startChar;
        int row = number / board.rows();
        int column = number % board.columns();
        return new Coordinate(row, column);

    }

    public static class ConverterException extends RuntimeException {
        public ConverterException(String message) {
            super(message);
        }
    }
}
