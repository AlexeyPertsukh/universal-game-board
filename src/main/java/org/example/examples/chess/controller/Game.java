package org.example.examples.chess.controller;

import org.example.board.Coordinate;
import org.example.examples.chess.model.BoardFactory;
import org.example.examples.chess.model.ChessBoard;
import org.example.examples.chess.model.Mover;
import org.example.examples.chess.model.Piece;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final ChessBoard board = BoardFactory.create();
    private final BoardRenderer boardRenderer = new BoardRenderer(board);
    private final CoordinateConverter coordinateConverter = new CoordinateConverter();
    private final Mover mover = new Mover(board);
    private Piece.Color moveColor = Piece.Color.WHITE;

    public void go() {
        printBoard();

        while (true) {
            System.out.printf("[%s] move: \n", moveColor);
            String keyWay = scanner.next();

            try {
                CoordinateConverter.Way way = coordinateConverter.stringToWay(keyWay);
                mover.move(moveColor, way.from, way.to);
                changeMoveColor();
                printBoard();
            } catch (CoordinateConverter.ConverterException | Mover.MoverException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void changeMoveColor() {
        moveColor = moveColor == Piece.Color.WHITE ? Piece.Color.BLACK : Piece.Color.WHITE;
    }

    private void printBoard() {
        boardRenderer.show();
        System.out.println();
    }
}
