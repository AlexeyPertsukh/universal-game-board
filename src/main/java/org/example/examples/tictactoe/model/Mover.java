package org.example.examples.tictactoe.model;

import org.example.board.Coordinate;
import org.example.examples.tictactoe.controller.CoordinateConverter;

public class Mover {
    private final static String ERROR = "illegal move";
    private final TicTacToeBaseBoard board;
    private final CoordinateConverter coordinateConverter;

    public Mover(TicTacToeBaseBoard board, CoordinateConverter coordinateConverter) {
        this.board = board;
        this.coordinateConverter = coordinateConverter;
    }

    public void move(String wayTo, char figure) {
        if (wayTo.length() != 1) {
            throw new MoverException(ERROR + ", must be one character: " + wayTo);
        }
        char ch = wayTo.charAt(0);
        Coordinate coordinate = coordinateConverter.charToCoordinate(ch);

        if (coordinate.row >= board.rows() || coordinate.row < 0 || coordinate.column >= board.columns() || coordinate.column < 0) {
            String message = ERROR + String.format(", the coordinate is outside the board: %c -> [row = %d, column = %d]", ch, coordinate.row, coordinate.column);
            throw new MoverException(message);
        }

        if (!board.isEmptyPlace(coordinate)) {
            String message = ERROR + String.format(", place is busy: %c -> [row = %d, column = %d]", ch, coordinate.row, coordinate.column);
            throw new MoverException(message);
        }

        board.put(coordinate, figure);
    }

    public static class MoverException extends RuntimeException {
        public MoverException(String message) {
            super(message);
        }
    }
}
