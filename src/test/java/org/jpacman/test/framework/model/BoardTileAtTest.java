package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Tile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test the Board.tileAt method by means of a series of test cases with
 * Parameterized data.
 *
 * @author Arie van Deursen, TU Delft, Feb 10, 2012
 */
@RunWith(Parameterized.class)
public class BoardTileAtTest {

    private int startx, starty;
	private Direction dir;
	private int nextx, nexty;
	private Board board;

	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;
	private static final int MAGICPARAMETER = 3;

	/**
	 * @param x asf
	 * @param y asf
	 * @param d asf
	 * @param nx asf
	 * @param ny asf
	 */
	public BoardTileAtTest(final int x, final int y, final Direction d,
	        final int nx, final int ny) {
		startx = x;
		starty = y;
		dir = d;
		nextx = nx;
		nexty = ny;
		board = new Board(WIDTH, HEIGHT);
	}

	 /**
     * askfas.
     */
	@Test
	public void testTileAtDirection() {
		Tile source = board.tileAt(startx, starty);
		Tile actual = board.tileAtDirection(source, dir);
		Tile desired = board.tileAt(nextx, nexty);
		assertEquals(desired, actual);
	}

	/**
	 *
	 * @return asd
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] values = new Object[][] {
				// x-axis boundaries, y random inpoints
				// left boundary
				{2, 2, Direction.UP, 2, 1 },
				{2, 2, Direction.DOWN, 2, MAGICPARAMETER },
				{2, 2, Direction.LEFT, 1, 2 },
				{2, 2, Direction.RIGHT, MAGICPARAMETER, 2 },
				// worm holes
				{0, 2, Direction.LEFT, WIDTH - 1, 2 },
				{WIDTH - 1, 2, Direction.RIGHT, 0, 2 },
				{2, 0, Direction.UP, 2, HEIGHT - 1 },
				{2, HEIGHT - 1, Direction.DOWN, 2, 0 } };
		return Arrays.asList(values);
	}

}
