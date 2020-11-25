

import org.junit.*;

/**
 * Unit test for WordSearch.
 */
public class WordSearchTest 
{
    WordSearch wordSearch = new WordSearch();
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
        String word = "et";

        // When
        String expected = "[(0 , 4)SW, (1 , 2)E]";
        String actual = wordSearch.findWordsAndCoordinates(grid, word);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinatesTestOriginal2() {
        // Given
        String word = "key";

        // When
        String expected = "[(0 , 1)SE, (0 , 2)S, (0 , 2)SW, (0 , 5)SW, (0 , 5)W, (2 , 5)NW]";
        String actual = wordSearch.findWordsAndCoordinates(grid2, word);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinates2(){
        String word = "et";

        String expected = "[(0 , 4)SW, (1 , 2)E]";

        String actual = wordSearch.findWordsAndCoordinates(grid, word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinates3(){
        String word = "key";

        String expected = "[(0 , 1)SE, (0 , 2)S, (0 , 2)SW, (0 , 5)W]";

        String actual = wordSearch.findWordsAndCoordinates(grid, word);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findWordsAndCoordinates4(){
        String word = "beep";

        String expected = "Not Found";

        String actual = wordSearch.findWordsAndCoordinates(grid2, word);

        Assert.assertEquals(expected, actual);
    }
}
