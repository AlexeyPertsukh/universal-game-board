package org.example.examples.tictactoe.controller;

import org.example.board.Coordinate;
import org.example.examples.tictactoe.model.Mover;
import org.example.examples.tictactoe.model.TicTacToeBoard;

import java.util.Scanner;

public class Game {
    private static final char[] figures = {'X', '0'};
    private final Scanner scanner = new Scanner(System.in);

    private final TicTacToeBoard board = new TicTacToeBoard();
    private final CoordinateConverter coordinateConverter = new CoordinateConverter(board, 'a');
    private final BoardRenderer boardRenderer = new BoardRenderer(board, coordinateConverter);
    private final Mover mover = new Mover(board, coordinateConverter);
    private char currentFigure = figures[0];

    public void go() {
        printBoard();

        while (true) {

            System.out.printf("[%c] move: \n", currentFigure);
            String address = scanner.next();

            try {
                Coordinate to = coordinateConverter.addressToCoordinate(address);
                mover.move(to, currentFigure);
                changeFigure();
                printBoard();

            } catch (CoordinateConverter.ConverterException | Mover.MoverException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void changeFigure() {
        currentFigure = currentFigure == figures[0] ? figures[1] : figures[0];
    }

    private void printBoard() {
        boardRenderer.show();
        System.out.println();
    }
}
