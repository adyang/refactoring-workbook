package rwb.ch3.matcher;

public class Matcher {
	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
		clipValuesOverLimit(actual, clipLimit);
		return isSameLength(expected, actual) && isWithinDelta(expected, actual, delta);
	}

	private void clipValuesOverLimit(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}

	private boolean isSameLength(int[] expected, int[] actual) {
		return actual.length == expected.length;
	}

	private boolean isWithinDelta(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++) {
			if (entryIsNotWithinDelta(expected[i], actual[i], delta))
				return false;
		}
		return true;
	}

	private boolean entryIsNotWithinDelta(int expectedEntry, int actualEntry, int delta) {
		return Math.abs(expectedEntry - actualEntry) > delta;
	}
}