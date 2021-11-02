import java.io.IOException;

public class ScrabblePrecision extends TextFileAccessor {
	// TODO: declare variables
	private final int[] SCRABBLE_SCORES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4,
			10 };
	int[] frequency = new int[26];
	String str;
	int ASCII_CODE_a = 97;
	int[] letterCounts;
	int totChCount = 0;
	int endNum;

	public ScrabblePrecision(String filename) throws IOException {
		openFile(filename);
		// TODO: initialize variables in constructor

	}

	@Override
	protected void processLine(String curLine) {
		// TODO: process each character from the current line
		char[] curLineChars = curLine.toCharArray();
		for (int i = 0; i < curLine.length(); i++) {
			frequency[curLineChars[i] - ASCII_CODE_a]++;
			totChCount++;
		}

	}

	private int getLetterPos(char ch) {
		// TODO: helper method to return the position for the character
		// if (SCRABBLE_SCORES[n].equalsIgnoreCase()) {
		for (int n = 0; n < SCRABBLE_SCORES.length; n++) {
			for (int i = 0; i < SCRABBLE_SCORES.length; i++) {
				char ch1 = str.charAt(i);
				if (Character.isLetter(ch1)) {
					// return ch - 97;
					int letterIndex = ch1 - ASCII_CODE_a; // will take a lowercase letter and convert it to a number
															// 0-25
					letterCounts[letterIndex]++;

				}

			}
		}
		return 0;

	}

	private double getOnesAverage() {
		// TODO: helper method to return the average frequency value in the supplied
		// text for the letters that have Scrabble score 1
		for (int i = 0; i < frequency.length; i++) {
			endNum = (frequency[i]) / totChCount;
		}
		return endNum;
	}

	@Override
	public void printReport() {
		// TODO: prints the table of relative frequencies given the text file
	}

}
