public class Main {

    public static void main(String[] args) {
        char[][] grid = {
                {'o', 'k', 'k', 'y', 'e', 'k'},
                {'p', 'e', 'e', 't', 'u', 'v'},
                {'y', 'j', 'y', 'y', 'r', 's'}
        };

        WordSearch wordSearch = new WordSearch(grid);
        String word = "et";
        wordSearch.findWordsAndCoordinates(word);
    }
}
