import java.util.ArrayList;
import java.util.List;

public class WordSearch{

//    Given a 2D grid of characters and a word, find all occurrences of given word in grid.
//
//    A word can be matched in all 8 directions at any point.
//    Word is said be found in a direction if all characters match in this direction (not in zig-zag form).
//    The solution should print the starting coordinate and the direction (north, east, south, west, etc..)
//    The 8 directions are North, South, East, West,...

    public char[][] grid;

    public enum Direction {
        NW, N, NE,
        W,      E,
        SW, S, SE
    }

    public String findWordsAndCoordinates(char[][] grid, String word) {
        this.grid = grid;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                check8Positions(row, column, 't');
            }
        }
        return null;
    }

    private List<Direction> check8Positions(int row, int column, char letter) {
        List<Direction> directions = new ArrayList<Direction>();

        if (indexesAreInRange(row - 1, column - 1) == letter)
            directions.add(Direction.NW);
        if (indexesAreInRange(row - 1, column) == letter)
            directions.add(Direction.N);
        if (indexesAreInRange(row - 1, column + 1) == letter)
            directions.add(Direction.NE);

        if (indexesAreInRange(row, column - 1) == letter)
            directions.add(Direction.W);
        if (indexesAreInRange(row, column + 1) == letter)
            directions.add(Direction.E);

        if (indexesAreInRange(row + 1, column - 1) == letter)
            directions.add(Direction.SW);
        if (indexesAreInRange(row + 1, column) == letter)
            directions.add(Direction.S);
        if (indexesAreInRange(row + 1, column + 1) == letter)
            directions.add(Direction.SE);

        System.out.println(directions.size());
        return directions;
    }

    // Makes sure both indexes are in range for multidimensional array.
    private char indexesAreInRange(int rowIndex, int columnIndex) {
        if (rowIndex > 0 && rowIndex < grid.length && columnIndex > 0 && columnIndex < grid[0].length) {
            return grid[rowIndex][columnIndex];
        }
        return '0';
    }

//    private void checkDirection(Direction) {
//    }
}




















