

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
//    char[][] grid2 = {
//            {'o', 'k', 'k', 'y', 'e', 'k'},
//            {'p', 'e', 'e', 't', 'e', 'v'},
//            {'y', 'j', 'y', 'y', 'r', 'k'}
//    };

    @Test
    public void findWordsAndCoordinatesTest() {
        // Given

        // When
        String expected = "[(0 , 4)SW, (1 , 2)E]";
        String actual = wordSearch.findWordsAndCoordinates(grid);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
