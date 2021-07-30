package tcsinterview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringReverserTest {

	@Test
	public void nullString() {
		char[] actual = null;
		StringReverser.reverseString(actual);
		char[] expected = null;

		assertArrayEquals(expected, actual);
	}

	@Test
	public void emptyString() {
		char[] actual = {};
		StringReverser.reverseString(actual);
		char[] expected = {};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneChar() {
		char[] actual = { 'A' };
		StringReverser.reverseString(actual);
		char[] expected = { 'A' };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoChars() {
		char[] actual = { 'A', 'B' };
		StringReverser.reverseString(actual);
		char[] expected = { 'B', 'A' };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void threeChars() {
		char[] actual = { 'A', 'B', 'C' };
		StringReverser.reverseString(actual);
		char[] expected = { 'C', 'B', 'A' };

		assertArrayEquals(expected, actual);
	}

	@Test
	public void longStringOddChars() {
		char[] actual = "This is a long string".toCharArray();
		StringReverser.reverseString(actual);

		char[] expected = "gnirts gnol a si sihT".toCharArray();

		assertArrayEquals(expected, actual);
	}

	@Test
	public void longStringEvenChars() {
		char[] actual = "This too is a long string".toCharArray();
		StringReverser.reverseString(actual);

		char[] expected = "gnirts gnol a si oot sihT".toCharArray();

		assertArrayEquals(expected, actual);
	}
}
