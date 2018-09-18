package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

public class IsPalindromic {

	@Test
	public void test_isPalindromic() {
		String input = "abcba";
		Assert.assertEquals(true, isPalindromic(input.toCharArray(), 0, input.length() - 1));
	}
	
	private static boolean isPalindromic(char[] input, int start, int end) {
		if(input[start] != input[end]) {
			return false;
		}
		
		if(start >= end) {
			return true;
		}
		
		return isPalindromic(input, start + 1, end - 1);
	}
}
