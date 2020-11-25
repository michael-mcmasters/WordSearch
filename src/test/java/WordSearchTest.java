

import org.junit.*;

/**
 * Unit test for WordSearch.
 */
public class WordSearchTest 
{
    char[][] grid = {
            {'o', 'k', 'k', 'y', 'e', 'k'},
            {'p', 'e', 'e', 't', 'u', 'v'},
            {'y', 'j', 'y', 'y', 'r', 's'}
    };
    char[][] grid2 = {
            {'o', 'k', 'k', 'y', 'e', 'k'},
            {'p', 'e', 'e', 't', 'e', 'v'},
            {'y', 'j', 'y', 'y', 'r', 'k'}
    };

    @Test
    public void findWordsAndCoordinatesTestOriginal() {
        // Given
        WordSearch wordSearch = new WordSearch(grid);
        String word = "et";

        // When
        String expected = "[(0 , 4)SW, (1 , 2)E]";
        String actual = wordSearch.findWordsAndCoordinates(word);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinatesTestOriginal2() {
        // Given
        WordSearch wordSearch = new WordSearch(grid2);
        String word = "key";

        // When
        String expected = "[(0 , 1)SE, (0 , 2)S, (0 , 2)SW, (0 , 5)SW, (0 , 5)W, (2 , 5)NW]";
        String actual = wordSearch.findWordsAndCoordinates(word);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinates2(){
        WordSearch wordSearch = new WordSearch(grid);
        String word = "et";

        String expected = "[(0 , 4)SW, (1 , 2)E]";

        String actual = wordSearch.findWordsAndCoordinates(word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinates3(){
        WordSearch wordSearch = new WordSearch(grid);
        String word = "key";

        String expected = "[(0 , 1)SE, (0 , 2)S, (0 , 2)SW, (0 , 5)W]";

        String actual = wordSearch.findWordsAndCoordinates(word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinates4(){
        WordSearch wordSearch = new WordSearch(grid2);
        String word = "beep";

        String expected = "Not Found";

        String actual = wordSearch.findWordsAndCoordinates(word);

        Assert.assertEquals(expected, actual);
    }
}
