package kata.numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

public class NumbersInWordsTest {
	
	@Test
	public void convert() {
		NumbersInWords numbersInWords = new NumbersInWords();
		Map<Long, String> numberAndWords = new HashMap<>();
		numberAndWords.put(1l, "one dollar");
		numberAndWords.put(5l, "five dollars");
		numberAndWords.put(15l, "fifteen dollars");
		numberAndWords.put(67l, "sixty seven dollars");
		numberAndWords.put(115l, "one hundred and fifteen dollars");
		numberAndWords.put(745l, "seven hundred and forty five dollars");
		numberAndWords.put(2740l, "two thousand seven hundred and forty dollars");
		numberAndWords.put(10046l, "ten thousand and forty six dollars");
		numberAndWords.put(201239l, "two hundred one thousand two hundred and thirty nine dollars");
		numberAndWords.put(3000816l, "three million eight hundred and sixteen dollars");
		numberAndWords.put(4080000008l, "four billion eighty million and eight dollars");

		for (Entry<Long, String> entry: numberAndWords.entrySet()) {
			Assert.assertEquals(entry.getValue(), numbersInWords.convert(entry.getKey()));
		}
 	}
	

}
