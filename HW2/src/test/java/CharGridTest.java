// Test cases for CharGrid -- a few basic tests are provided.

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CharGridTest {
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};

		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}

    @Test
    public void testSimplePlusSign_Length1() {
        //   a
        //  aaa (tâm ở giữa, len = 2)
        //   a
        char[][] grid = {
                {' ', 'a', ' '},
                {'a', 'a', 'a'},
                {' ', 'a', ' '},
        };
        CharGrid cg = new CharGrid(grid);
        assertEquals(1, cg.countPlus());
    }

    @Test
    public void testSimplePlusSign_Length2() {
        char[][] grid = {
                {' ', 'b', ' '},
                {' ', 'b', ' '},
                {'b', 'b', 'b', 'b', 'b'},
                {' ', 'b', ' '},
                {' ', 'b', ' '},
        };
        CharGrid cg = new CharGrid(grid);
        assertEquals(1, cg.countPlus());
    }

    @Test
    public void testFail_DifferentLengths() {
        char[][] grid = {
                {' ', 'c', ' '},
                {'c', 'c', 'c'},
                {' ', 'c', ' '},
                {' ', 'c', ' '},
        };
        CharGrid cg = new CharGrid(grid);
        assertEquals(0, cg.countPlus());
    }
}
