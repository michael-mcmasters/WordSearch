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

    // Originally had these in order. (NW, N, NE, W, E, SW, S, SE).
    // But rearranged them so that the loop below iterates in this order, because this is the order the tests wanted them in.
    public enum Direction {
        N, NE, E, S, SW, W, SE, NW
    }

    public String findWordsAndCoordinates(char[][] grid, String word) {
        List<String> answers = new ArrayList<>();

        this.grid = grid;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {

                // Condition here for debugging breakpoint.
                if (row == 0 && column == 5) {
                    System.out.println(grid[row][column]);
                }

                if (grid[row][column] == word.charAt(0)) {
                    for (Direction direction : Direction.values()) {
                        int index = 1;
                        int matches = 0;
                        boolean continueSearching = true;
                        while (continueSearching) {
                            char letter = word.charAt(index);
                            int dirDistance = index;
                            char letterInDir = getNextCharInDirection(direction, row, column, dirDistance);
                            if (letter == letterInDir) {
                                matches++;
                            } else {
                                continueSearching = false;
                                continue;
                            }

                            if (index == word.length() - 1) {
                                if (matches > 0)
                                    answers.add("(" +row + " , " + column + ")" + direction);
                                continueSearching = false;
                                continue;
                            }

                            index++;
                        }

                    }
                }
            }
        }
        System.out.println(answers);
        return answers.toString();
    }

    private char getNextCharInDirection(Direction direction, int row, int column, int dirDistance) {
        char letter = '0';
        switch(direction) {
            case NW:
                letter = indexesAreInRange(row - dirDistance, column - dirDistance);
                break;
            case N:
                letter = indexesAreInRange(row - dirDistance, column);
                break;
            case NE:
                letter = indexesAreInRange(row - dirDistance, column + dirDistance);
                break;

            case W:
                letter = indexesAreInRange(row, column - dirDistance);
                break;
            case E:
                letter = indexesAreInRange(row, column + dirDistance);
                break;

            case SW:
                letter = indexesAreInRange(row + dirDistance, column - dirDistance);
                break;
            case S:
                letter = indexesAreInRange(row + dirDistance, column);
                break;
            case SE:
                letter = indexesAreInRange(row + dirDistance, column + dirDistance);
                break;
        }
        return letter;
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

        return directions;
    }

    // Makes sure both indexes are in range for multidimensional array.
    private char indexesAreInRange(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < grid.length && columnIndex >= 0 && columnIndex < grid[0].length) {
            return grid[rowIndex][columnIndex];
        }
        return '0';
    }

//    private void checkDirection(Direction) {
//    }
}




















