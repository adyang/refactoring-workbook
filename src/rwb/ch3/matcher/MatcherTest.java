package rwb.ch3.matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MatcherTest {
	private static final int[] EXPECTED = new int[] { 10, 50, 30, 98 };
	private static final int CLIP_LIMIT = 100;
	private static final int DELTA = 5;

	private Matcher matcher;

	@Before
	public void setUp() {
		matcher = new Matcher();
	}

	@Test
	public void testMatch_WhenSameLengthAndWithinDelta() {
		int[] actual = new int[] { 12, 55, 25, 110 };
		assertTrue(matcher.match(EXPECTED, actual, CLIP_LIMIT, DELTA));
	}

	@Test
	public void testMatch_WhenSameLengthButExceedDelta() {
		int[] actual = new int[] { 10, 60, 30, 98 };
		assertFalse(matcher.match(EXPECTED, actual, CLIP_LIMIT, DELTA));
	}

	@Test
	public void testMatch_WhenDifferentLength() {
		int[] actual = new int[] { 10, 50, 30 };
		assertFalse(matcher.match(EXPECTED, actual, CLIP_LIMIT, DELTA));
	}
}
