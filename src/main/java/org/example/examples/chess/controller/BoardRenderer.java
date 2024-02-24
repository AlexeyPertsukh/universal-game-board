package org.example.examples.chess.controller;

import org.example.board.Coordinate;
import org.example.examples.chess.model.ChessBoard;

public class BoardRenderer {
    private final static String VERT_LINE = "|";
    private final static String HOR_LINE = "+------------------------------------+";
    private static final char SPACE = '\u2003';
    private static final String FIGURE_SQUARE_TEMPLATE = " %c ";
    private static final String EMPTY_SQUARE = String.format(FIGURE_SQUARE_TEMPLATE, '\u2003');
    private final ChessBoard board;

    public BoardRenderer(ChessBoard board) {
        this.board = board;
    }

    public void show() {

        for (int row = 0; row < board.rows(); row++) {
            printHorizontalLine();

            String rowNumber = (String.format(" %d ", 8 - row));
            StringBuilder builder = new StringBuilder(rowNumber);

            for (int column = 0; column < board.columns(); column++) {
                Coordinate coordinate = new Coordinate(row, column);
                builder.append(VERT_LINE);
                String square = EMPTY_SQUARE;
                if (!board.isEmpty(coordinate)) {
                    square = String.format(FIGURE_SQUARE_TEMPLATE, board.get(coordinate).getFigure());
                }
                builder.append(square);
            }
            builder.append(VERT_LINE);
            System.out.println(builder.toString());
        }
        printHorizontalLine();
        System.out.println("     A    B   C    D    E    F   G    H");
    }

    private void printHorizontalLine() {
        System.out.println("   " + HOR_LINE);
    }

}
