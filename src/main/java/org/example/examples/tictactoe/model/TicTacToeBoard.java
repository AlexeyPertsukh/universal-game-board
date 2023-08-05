package org.example.examples.tictactoe.model;

import org.example.board.BaseBoard;

public class TicTacToeBoard extends BaseBoard<Character> {
    private final static int BOARD_SIDE = 3;
    public TicTacToeBoard() {
        super(BOARD_SIDE, BOARD_SIDE);
    }
}
