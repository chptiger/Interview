package companies.la.sony.glassdoor;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {

	@Test
	public void test_reverseString() {
		String input = "I love google";
		Assert.assertEquals("google love I", reverseString(input));
	}
// Time Complexity : N
	private static String reverseString(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}

		input = reverse(input, 0, input.length() - 1); // n/2

		String[] strs = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			str = reverse(str, 0, str.length() - 1);
			sb.append(str + " ");
		}
		return sb.toString().substring(0, sb.length() - 1); // n
	}

	private static String reverse(String str, int start, int end) {
		if (start >= end) {
			return str;
		}
		str = swap(str, start, end);
		return reverse(str, start + 1, end - 1);
	}

	private static String swap(String str, int start, int end) {
		char[] tmp = str.toCharArray();
		char ss = tmp[start];
		tmp[start] = tmp[end];
		tmp[end] = ss;
		return new String(tmp);
	}
}
