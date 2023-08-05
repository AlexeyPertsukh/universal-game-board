package org.example.examples.chess.controller;

import org.example.board.Coordinate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateConverter {
    private final static String REGEX_WAY = "[a-hA-H][1-8]-[a-hA-H][1-8]";
    private final Pattern wayPattern = Pattern.compile(REGEX_WAY);

    public CoordinateConverter() {
    }

    public Way stringToWay(String s) {
        Matcher m = wayPattern.matcher(s);
        if (!m.matches()) {
            String message = String.format("the way must match %s, but was : %s", REGEX_WAY, s);
            throw new ConverterException(message);
        }

        Coordinate from = addressToCoordinate(s.substring(0, 2));
        Coordinate to = addressToCoordinate(s.substring(3, 5));
        return new Way(from, to);
    }

//    public String coordinateToAddress(Coordinate coordinate) {
//        char chRow = (char) ('1' + 7 - coordinate.row);
//        char chColumn = (char) ('a' + coordinate.column);
//        return String.format("%c%c", chColumn, chRow);
//    }

    private Coordinate addressToCoordinate(String address) {
        address = address.toLowerCase();
        int row = '8' - address.charAt(1);
        int column = address.charAt(0) - 'a';
        return new Coordinate(row, column);
    }

    public static class Way {
        public final Coordinate from;
        public final Coordinate to;

        public Way(Coordinate from, Coordinate to) {
            this.from = from;
            this.to = to;
        }
    }

    public static class ConverterException extends RuntimeException {
        public ConverterException(String message) {
            super(message);
        }
    }

}
