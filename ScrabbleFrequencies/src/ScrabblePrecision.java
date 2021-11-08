import java.io.IOException;

public class ScrabblePrecision extends TextFileAccessor {
	// TODO: declare variables
	private final String[] ALPHABET = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	private final int[] SCRABBLE_SCORES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4,
			10 };
	private final int ASCII_CODE_a = 97;
	private int[] frequency;
	private int numOnes;

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

	private int getLetterPos(char ch) {
		return ch - ASCII_CODE_a;
	}

	private double getOnesAverage() {
		// TODO: helper method to return the average frequency value in the supplied
		// text for the letters that have Scrabble score 1
		return (double) numOnes / 10;
	}

	@Override
	public void printReport() {
		// TODO: prints the table of relative frequencies given the text file
		double oneAvg = getOnesAverage();
		for (int i = 0; i < SCRABBLE_SCORES.length; i++) {
			System.out.print(ALPHABET[i]);
			System.out.printf("%6d", SCRABBLE_SCORES[i]);
			System.out.printf("%8.2f%n", (double) oneAvg / frequency[i]);
		}
	}

}
