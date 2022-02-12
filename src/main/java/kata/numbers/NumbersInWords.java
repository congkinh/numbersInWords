package kata.numbers;

import java.text.DecimalFormat;

public class NumbersInWords {

	private static final String[] TENS_NAMES = {
			"",
			" ten",
			" twenty",
			" thirty",
			" forty",
			" fifty",
			" sixty",
			" seventy",
			" eighty",
			" ninety"
	};

	private static final String[] NUM_NAMES = {
			"",
			" one",
			" two",
			" three",
			" four",
			" five",
			" six",
			" seven",
			" eight",
			" nine",
			" ten",
			" eleven",
			" twelve",
			" thirteen",
			" fourteen",
			" fifteen",
			" sixteen",
			" seventeen",
			" eighteen",
			" nineteen"
	};

	/**
	 * For sake of simplicity, this method is only used for the given number less than one trillions.
	 * @param number
	 * @return
	 */
	public String convert(long number) {
		// 0 to 999 999 999 999
		if (number == 0) {
			return "zero dollar";
		} else if (number == 1) {
			return "one dollar";
		}

		String snumber = Long.toString(number);

		// pad with "0"
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0,3));
		// nnnXXXnnnnnn
		int millions  = Integer.parseInt(snumber.substring(3,6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6,9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9,12));
		
		String result = convertPart(billions, " billion ")
				+ convertPart(millions, " million ")
				+ convertPart(hundredThousands, " thousand ")
				+ convertLessThanOneThousand(thousands, true);

		// remove extra spaces!
		result = result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ") + " dollars";
		if (result.startsWith("and ")) {
			return result.substring(4);
		}
		return result;
	}
	
	private String convertPart(int partInt, String partString) {
		if (partInt == 0) {
			return "";
		}
		return convertLessThanOneThousand(partInt, false) + partString;
	}

	private String convertLessThanOneThousand(int number, boolean withAnd) {
		String remainder;

		if (number % 100 < 20){
			remainder = NUM_NAMES[number % 100];
			number /= 100;
		} else {
			remainder = NUM_NAMES[number % 10];
			number /= 10;

			remainder = TENS_NAMES[number % 10] + remainder;
			number /= 10;
		}
		if (number == 0) {
			return (withAnd ? "and" : "") + remainder;
		}
		return NUM_NAMES[number] + " hundred " + (withAnd ? "and" : "") + remainder;
	}

}
