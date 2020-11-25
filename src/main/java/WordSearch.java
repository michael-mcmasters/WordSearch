import java.util.ArrayList;
import java.util.List;

public class WordSearch{

    public char[][] grid;

    // Originally had these in order. (NW, N, NE, W, E, SW, S, SE).
    // But rearranged them so that the loop below iterates in this order, because this is the order the tests want them returned as.
    public enum Direction {
        N, NE, E, S, SW, W, SE, NW
    }

    // Loops through every row and column in the grid.
    // If the first letter of that row and column matches the first letter of word,
    // it calls a function to continue searching for word in all 8 directions from that position.
    public String findWordsAndCoordinates(char[][] grid, String word) {
        this.grid = grid;

        List<String> answers = new ArrayList<>();
        int rows = grid.length;
        int columns = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == word.charAt(0)) {
                    answers.addAll(searchForWordInAllDirections(row, column, word));
                }
            }
        }

        if (answers.size() == 0)
            return "Not Found";

        return answers.toString();
    }

    // Search for word in all 8 directions from the given coordinates [row][column]. Return all matches.
    private List<String> searchForWordInAllDirections(int row, int column, String word) {
        List<String> answers = new ArrayList<String>();

        for (Direction direction : Direction.values()) {
            int index = 1;
            boolean charactersMatch = true;
            while (charactersMatch) {
                if (word.charAt(index) != getNextCharInDirection(direction, row, column, index)) {
                    charactersMatch = false;
                    continue;
                }

                // If ever character in the word has been searched and the loop hasn't been stopped, this is a match.
                if (index == word.length() - 1) {
                    answers.add(String.format("(%d , %d)%s", row, column, direction));
                    charactersMatch = false;
                }
                index++;
            }
        }
        return answers;
    }



    // Returns char if one is found. Otherwise returns number 0 (as a character).
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

    // Makes sure both indexes are in range of the multidimensional array.
    // Returns 0 (as character) if not.
    private char indexesAreInRange(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < grid.length && columnIndex >= 0 && columnIndex < grid[0].length) {
            return grid[rowIndex][columnIndex];
        }
        return '0';
    }
}




















