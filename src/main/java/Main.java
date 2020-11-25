public class Main {

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] grid = {
                {'o', 'k', 'k', 'y', 'e', 'k'},
                {'p', 'e', 'e', 't', 'u', 'v'},
                {'y', 'j', 'y', 'y', 'r', 's'}
        };
        ws.findWordsAndCoordinates(grid);
    }
}
