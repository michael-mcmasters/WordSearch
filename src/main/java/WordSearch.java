import java.util.ArrayList;
import java.util.List;

public class WordSearch{

    public char[][] grid;

    // Enum values must be in this order because this is the order the tests want the results returned as.
    public enum Direction {
        N, NE, E, S, SW, W, SE, NW
    }



    public WordSearch(char[][] grid) {
        this.grid = grid;
    }

    // Loops through every row and column in the grid.
    // If the first letter of that row and column matches the first letter of word,
    // it calls a function to continue searching for word in all 8 directions from that position.
    public String findWordsAndCoordinates(String word) {
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

    // Search for word in all 8 directions from the given coordinates grid[row][column]. Return all matches.
    private List<String> searchForWordInAllDirections(int row, int column, String word) {
        List<String> answers = new ArrayList<String>();

        for (Direction direction : Direction.values()) {

            boolean searchInDirection = true;
            int index = 1;
            while (searchInDirection) {
                if (word.charAt(index) == getNextCharInDirection(row, column, index, direction)) {
                    if (index == word.length() - 1) {
                        // If this is the last char in the word, and every char matched, it is a match.
                        answers.add(String.format("(%d , %d)%s", row, column, direction));
                        searchInDirection = false;
                    }
                    index++;
                } else {
                    // If any chars don't match, stop searching in this direction
                    searchInDirection = false;
                }
            }

        }
        return answers;
    }



    // Returns char if one is found. Otherwise returns 0 (as a character).
    // dirDistance is how far from the origin point to search.
    // For example: If looking for 1st index of word, we search 1 row and 1 column away... If searching for 2nd index of word, we search 2 rows and 2 columns away... etc.
    private char getNextCharInDirection(int row, int column, int dirDistance, Direction direction) {
        char letter = '0';
        switch(direction) {
            case NW:
                letter = getCharIfInRange(row - dirDistance, column - dirDistance);
                break;
            case N:
                letter = getCharIfInRange(row - dirDistance, column);
                break;
            case NE:
                letter = getCharIfInRange(row - dirDistance, column + dirDistance);
                break;

            case W:
                letter = getCharIfInRange(row, column - dirDistance);
                break;
            case E:
                letter = getCharIfInRange(row, column + dirDistance);
                break;

            case SW:
                letter = getCharIfInRange(row + dirDistance, column - dirDistance);
                break;
            case S:
                letter = getCharIfInRange(row + dirDistance, column);
                break;
            case SE:
                letter = getCharIfInRange(row + dirDistance, column + dirDistance);
                break;
        }
        return letter;
    }

    // Makes sure both indexes are in range of the multidimensional array. Returns 0 (as character) if not.
    // For example, there is nothing north west of grid[0][0] but there is for grid[1][1]. This checks for that.
    private char getCharIfInRange(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < grid.length && columnIndex >= 0 && columnIndex < grid[0].length) {
            return grid[rowIndex][columnIndex];
        }
        return '0';
    }
}




















