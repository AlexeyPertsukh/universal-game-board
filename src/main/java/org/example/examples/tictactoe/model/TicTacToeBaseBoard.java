package org.example.examples.tictactoe.model;

import org.example.board.BaseBoard;

public class TicTacToeBaseBoard extends BaseBoard<Character> {
    private final static int BOARD_SIDE = 3;
    public TicTacToeBaseBoard() {
        super(BOARD_SIDE, BOARD_SIDE);
    }
}
