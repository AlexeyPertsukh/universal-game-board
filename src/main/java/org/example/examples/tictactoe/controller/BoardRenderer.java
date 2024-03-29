package org.example.examples.tictactoe.controller;

import org.example.board.Coordinate;
import org.example.examples.tictactoe.model.TicTacToeBoard;

public class BoardRenderer {
    private final TicTacToeBoard board;
    private final CoordinateConverter coordinateConverter;

    public BoardRenderer(TicTacToeBoard board, CoordinateConverter coordinateConverter) {
        this.board = board;
        this.coordinateConverter = coordinateConverter;
    }

    public void show() {
        String template = " %c ";
        for (int row = 0; row < board.rows(); row++) {
            StringBuilder builder = new StringBuilder();
            for (int column = 0; column < board.columns(); column++) {
                Coordinate coordinate = new Coordinate(row, column);

                char ch;
                if (board.isEmpty(coordinate)) {
                    ch = coordinateConverter.coordinateToAddress(coordinate);
                } else {
                    ch = board.get(coordinate);
                }

                builder.append(String.format(template, ch));
                if (column < board.columns() - 1) {
                    builder.append("|");
                }
            }
            System.out.println(builder.toString());

            if (row < board.rows() - 1) {
                System.out.println("---+---+---");
            }

        }
    }


}
