package org.example.examples.chess.model;

import org.example.examples.chess.model.ChessBoard;
import org.example.examples.chess.model.Piece;

public class BoardFactory {
    private BoardFactory() {
    }

    public static ChessBoard create() {
        ChessBoard board = new ChessBoard();

        final int whiteFirstRow = 7;
        final int blackFirstRow = 0;

        final int whitePawnRow = 6;
        final int blackPawnRow = 1;

        board.put(whiteFirstRow, 0, new Piece(WhiteFigure.ROOK.getFigure(), Piece.Color.WHITE));
        board.put(whiteFirstRow, 7, new Piece(WhiteFigure.ROOK.getFigure(), Piece.Color.WHITE));

        board.put(whiteFirstRow, 1, new Piece(WhiteFigure.KNIGHT.getFigure(), Piece.Color.WHITE));
        board.put(whiteFirstRow, 6, new Piece(WhiteFigure.KNIGHT.getFigure(), Piece.Color.WHITE));

        board.put(whiteFirstRow, 2, new Piece(WhiteFigure.BISHOP.getFigure(), Piece.Color.WHITE));
        board.put(whiteFirstRow, 5, new Piece(WhiteFigure.BISHOP.getFigure(), Piece.Color.WHITE));

        board.put(whiteFirstRow, 3, new Piece(WhiteFigure.QUEEN.getFigure(), Piece.Color.WHITE));
        board.put(whiteFirstRow, 4, new Piece(WhiteFigure.KING.getFigure(), Piece.Color.WHITE));


        board.put(blackFirstRow, 0, new Piece(BlackFigure.ROOK.getFigure(), Piece.Color.BLACK));
        board.put(blackFirstRow, 7, new Piece(BlackFigure.ROOK.getFigure(), Piece.Color.BLACK));

        board.put(blackFirstRow, 1, new Piece(BlackFigure.KNIGHT.getFigure(), Piece.Color.BLACK));
        board.put(blackFirstRow, 6, new Piece(BlackFigure.KNIGHT.getFigure(), Piece.Color.BLACK));

        board.put(blackFirstRow, 2, new Piece(BlackFigure.BISHOP.getFigure(), Piece.Color.BLACK));
        board.put(blackFirstRow, 5, new Piece(BlackFigure.BISHOP.getFigure(), Piece.Color.BLACK));

        board.put(blackFirstRow, 3, new Piece(BlackFigure.QUEEN.getFigure(), Piece.Color.BLACK));
        board.put(blackFirstRow, 4, new Piece(BlackFigure.KING.getFigure(), Piece.Color.BLACK));

        for (int i = 0; i < board.columns(); i++) {
            board.put(whitePawnRow, i, new Piece(WhiteFigure.PAWN.getFigure(), Piece.Color.WHITE));
            board.put(blackPawnRow, i, new Piece(BlackFigure.PAWN.getFigure(), Piece.Color.BLACK));
        }
        return board;
    }

    private enum WhiteFigure {
        PAWN('♟'),
        KNIGHT('♞'),
        BISHOP('♝'),
        ROOK('♜'),
        QUEEN('♛'),
        KING('♚');

        private final char figure;

        WhiteFigure(char figure) {
            this.figure = figure;
        }

        public char getFigure() {
            return figure;
        }
    }

    private enum BlackFigure {
        PAWN('♙'),
        KNIGHT('♘'),
        BISHOP('♗'),
        ROOK('♖'),
        QUEEN('♕'),
        KING('♔');

        private final char figure;

        BlackFigure(char figure) {
            this.figure = figure;
        }

        public char getFigure() {
            return figure;
        }
    }
}
