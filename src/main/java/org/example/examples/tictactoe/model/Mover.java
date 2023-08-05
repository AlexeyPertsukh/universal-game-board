package org.example.examples.tictactoe.model;

import org.example.board.Coordinate;
import org.example.examples.tictactoe.controller.CoordinateConverter;

public class Mover {
    private final static String ERROR = "illegal move";
    private final TicTacToeBoard board;

    public Mover(TicTacToeBoard board, CoordinateConverter coordinateConverter) {
        this.board = board;
    }

    public void move(Coordinate to, char figure) {
        validate(to);
        board.put(to, figure);
    }

    private void validate(Coordinate to) {
        if (to.row >= board.rows() || to.row < 0 || to.column >= board.columns() || to.column < 0) {
            String message = String.format("%s, the coordinate is outside the board: [row = %d, column = %d]", ERROR, to.row, to.column);
            throw new MoverException(message);
        }

        if (!board.isEmptyPlace(to)) {
            String message = String.format("%s, place is busy: [row = %d, column = %d]", ERROR, to.row, to.column);
            throw new MoverException(message);
        }
    }

    public static class MoverException extends RuntimeException {
        public MoverException(String message) {
            super(message);
        }
    }
}
