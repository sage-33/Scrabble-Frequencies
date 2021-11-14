import java.io.IOException;

/**
 * Represents a text file where contents are scanned and the frequency of each
 * letter is saved resulting with the Scrabble values of each letter respective
 * to that file (which is calculated by the ratios of each letter to numOnes)
 * and their Scrabble scores being printed out.
 * 
 * @author sagesilberman
 *
 */
public class ScrabblePrecision extends TextFileAccessor {
	private final String[] ALPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" }; // array of the English alphabet
	private final int[] SCRABBLE_SCORES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4,
			10 }; // array of respective Scrabble scores to each letter
	private final int ASCII_CODE_a = 97; // a number that represents the letter "a"
	private int[] frequency; // frequency of letters array
	private int numOnes; // baseline of the most common letters

	/**
	 * Initializes the code by setting the starting value for numOnes to 0 and
	 * frequency as an array with 26 values. Opens the file but throws IOException
	 * if it can't open the file.
	 * 
	 * @param filename the name of file
	 * @throws IOException if can't open file
	 */
	public ScrabblePrecision(String filename) throws IOException {
		openFile(filename);
		numOnes = 0;
		frequency = new int[26];

	}

	@Override
	protected void processLine(String curLine) {
		char[] curLineArr = curLine.toLowerCase().toCharArray();
		for (int i = 0; i < curLineArr.length; i++) {
			if (Character.isLetter(curLineArr[i]) && getLetterPos(curLineArr[i]) < 26) {
				frequency[getLetterPos(curLineArr[i])]++;
				if (SCRABBLE_SCORES[getLetterPos(curLineArr[i])] == 1) {
					numOnes++;
				}
			}

		}

	}

	/**
	 * Returns the position of a character by assigning each letter of the alphabet
	 * to a number
	 * 
	 * @param ch the character from file
	 * @return the position of a character by assigning each letter of the alphabet
	 *         to a number
	 */
	private int getLetterPos(char ch) {
		return ch - ASCII_CODE_a;
	}

	/**
	 * Returns the average frequency value in the supplied text for the letters that
	 * has a Scrabble Score of 1
	 * 
	 * @return the average frequency value in the supplied text for the letters that
	 *         has a Scrabble Score of 1
	 */
	private double getOnesAverage() {
		return (double) numOnes / 10;
	}

	@Override
	public void printReport() {
		double oneAvg = getOnesAverage();
		for (int i = 0; i < SCRABBLE_SCORES.length; i++) {
			System.out.print(ALPHABET[i]);
			System.out.printf("%6d", SCRABBLE_SCORES[i]);
			System.out.printf("%8.2f%n", (double) oneAvg / frequency[i]);
		}
	}

}
