import java.util.ArrayList;
import java.util.List;

public class WordSearch{

//    Given a 2D grid of characters and a word, find all occurrences of given word in grid.
//
//    A word can be matched in all 8 directions at any point.
//    Word is said be found in a direction if all characters match in this direction (not in zig-zag form).
//    The solution should print the starting coordinate and the direction (north, east, south, west, etc..)
//    The 8 directions are North, South, East, West,...

    public enum Direction {
        NW, N, NE,
        W,      E,
        SW, S, SE
    }

    public String findWordsAndCoordinates(char[][] grid) {
        System.out.println(check8Positions());
        return null;
    }

    private Direction check8Positions() {
        return Direction.NW;
    }

}

