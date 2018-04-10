package musicpreferencevisualization;

import student.TestCase;

/**
 * Test all methods and constructors in the Song class. It will also test hobby,
 * region, and major classes.
 * Because it will need to use them here. It is easier to test the already made ones
 * here than make more in another test class
 * 
 * @author Jonathan ljon15
 * @version 1.0
 *
 */
public class SongTest extends TestCase {

    // ~~~~~~~~~~ Fields ~~~~~~~~~~~~~
    private Song ah;
//    private Hobby hob;
//    private Region reg;
//    private Major maj;
//    private int[][] ray;


    // ~~~~~~~~~~ SetUp ~~~~~~~~~~~
    public void setUp() {
        ah = new Song("John Denver", "Country Roads", "Country", 1971, 10);
    }


    // ~~~~~~~~~~~~~~~~ TestCases ~~~~~~~~~~~~~~~
    public void testGetterMethods() {
        assertEquals("John Denver", ah.getName());
        assertEquals("Country Roads", ah.getTitle());
        assertEquals("Country", ah.getGenre());
        assertEquals(1971, ah.getReleaseYear());
        assertEquals(10, ah.getIndex());

    }

}
