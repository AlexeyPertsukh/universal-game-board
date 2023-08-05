package org.example.examples.chess.model;

public class Piece {
    private final char figure;
    private final Color color;

    public Piece(char figure, Color color) {
        this.figure = figure;
        this.color = color;
    }

    public char getFigure() {
        return figure;
    }

    public Color getColor() {
        return color;
    }

    public enum Color {
        WHITE,
        BLACK;
    }
}
