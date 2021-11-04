import java.io.IOException;

public class ScrabblePrecision extends TextFileAccessor {
	// TODO: declare variables
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
		// TODO: process each character from the current line
		char[] curLineChars = curLine.toLowerCase().toCharArray();
		for (int i = 0; i < curLine.length(); i++) {
			if (Character.isLetter(i)) {
				int letterIndex = getLetterPos(curLineChars[i]);
				frequency[letterIndex]++;
				if (SCRABBLE_SCORES[letterIndex] == 1) {
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
		for (int i = 0; i < 26; i++) {
			System.out.printf("a");
			System.out.printf("%-5.2d%n", i);
		}
	}

}
