package tcsinterview;

public class StringReverser {
	public static void reverseString(char[] s) {
		if (s == null)
			return;

		char tempChar;
		int invertedIndex;

		for (int index = 0; index < s.length / 2; index++) {
			invertedIndex = s.length - 1 - index;

			tempChar = s[index];
			s[index] = s[invertedIndex];
			s[invertedIndex] = tempChar;
		}
	}

	public static void main(String[] args) {
		System.out.println("test");
	}
}