package org.example.examples.tictactoe.controller;

import org.example.examples.tictactoe.model.Mover;
import org.example.examples.tictactoe.model.TicTacToeBaseBoard;

import java.util.Scanner;

public class Game {
    private static final char[] figures = {'X', '0'};
    private final Scanner scanner = new Scanner(System.in);

    private final TicTacToeBaseBoard board = new TicTacToeBaseBoard();
    private final CoordinateConverter coordinateConverter = new CoordinateConverter(board, 'a');
    private final BoardRenderer boardRenderer = new BoardRenderer(board, coordinateConverter);
    private final Mover mover = new Mover(board, coordinateConverter);

    public void go() {
        char currentFigure = figures[0];

        boardRenderer.show();
        System.out.println();

        while (true) {

            System.out.println(currentFigure + ", move:");

            String wayTo = scanner.next();

            try{
                mover.move(wayTo, currentFigure);
            } catch (Mover.MoverException e) {
                System.out.println(e.getMessage());
                continue;
            }

            currentFigure = currentFigure == figures[0] ? figures[1] : figures[0];
            boardRenderer.show();
            System.out.println();

        }
    }
}
