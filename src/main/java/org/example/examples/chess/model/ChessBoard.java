package org.example.examples.chess.model;

import org.example.board.BaseBoard;

public class ChessBoard extends BaseBoard<Piece> {
    private final static int BOARD_SIDE = 8;
    public ChessBoard() {
        super(BOARD_SIDE, BOARD_SIDE);
    }
}
