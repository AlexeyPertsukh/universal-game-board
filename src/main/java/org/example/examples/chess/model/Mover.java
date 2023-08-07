package org.example.examples.chess.model;

import org.example.board.Coordinate;

public class Mover {
    private final ChessBoard board;
    private final static String ERROR = "illegal move";

    public Mover(ChessBoard board) {
        this.board = board;
    }

    public void move(Piece.Color moveColor, Coordinate from, Coordinate to) {
        validate(moveColor, from, to);

        Piece piece = board.remove(from);
        board.put(to, piece);

    }

    private void validate(Piece.Color moveColor, Coordinate from, Coordinate to) {
        if (!isValidCoordinate(from)) {
            String message = String.format("%s, the coordinate is outside the board: %s]", ERROR, from);
            throw new MoverException(message);
        }

        if (!isValidCoordinate(to)) {
            String message = String.format("%s, the coordinate is outside the board: %s]", ERROR, to);
            throw new MoverException(message);
        }

        if (board.isEmptyPlace(from)) {
            String message = String.format("%s, no figure by coordinate: %s", ERROR, from);
            throw new MoverException(message);
        }

        Piece piece = board.get(from);

        if(moveColor != piece.getColor()) {
            String message = String.format("%s, your color is %s, you can't move %s pieces", ERROR, moveColor, piece.getColor());
            throw new MoverException(message);
        }

        if (!board.isEmptyPlace(to) && board.get(to).getColor() == piece.getColor()) {
            String message = String.format("%s, you can't kill a chess piece of your own color", ERROR);
            throw new MoverException(message);
        }
    }

    private boolean isValidCoordinate(Coordinate c) {
        return c.row >= 0 && c.row < board.rows() && c.column >= 0 && c.column < board.columns();
    }

    public static class MoverException extends RuntimeException {
        public MoverException(String message) {
            super(message);
        }
    }
}
