package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

/**
 * A palindrome is a string which reads the same in both directions. For example, SS = "aba" is a palindrome, SS = "abc" is not.
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

	Example 1:
		Input: "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
		
	Example 2:
		Input: "cbbd"
		Output: "bb"

Solution:
	https://leetcode.com/problems/longest-palindromic-substring/solution/
	http://www.cnblogs.com/grandyang/p/4464476.html
	https://www.cnblogs.com/yuzhangcmu/p/4189068.html
	详细图解：
			http://windliang.cc/2018/08/05/leetCode-5-Longest-Palindromic-Substring/

 * @author xx65
 *
 */
public class LongestPalindromicSubstring_5 {
	
	@Test
	public void test_longestPalindromicSubsring() {
		String input = "babad";
		Assert.assertEquals("bab", longestPalindromicSubsringDP(input.toCharArray()));
		Assert.assertEquals("aba", longestPalindromicSubsringExpandAroundCenter(input.toCharArray()));
	}
	/**
	此题还可以用动态规划Dynamic Programming来解，根Palindrome Partitioning II 拆分回文串之二的解法很类似，
	我们维护一个二维数组dp，其中dp[i][j]表示字符串区间[i, j]是否为回文串，
	当i = j时，只有一个字符，肯定是回文串，
	如果i = j + 1，说明是相邻字符，此时需要判断s[i]是否等于s[j]，
	如果i和j不相邻，即i - j >= 2时，除了判断s[i]和s[j]相等之外，dp[j + 1][i - 1]若为真，就是回文串，
	通过以上分析，可以写出递推式如下：

	dp[i, j] = 1                                         if i == j

           = s[i] == s[j]                                if j = i + 1

           = s[i] == s[j] && dp[i + 1][j - 1]            if j > i + 1   
	**/
	private static String longestPalindromicSubsringDP(char[] input) {
		if(input == null || input.length == 0) {
			return "";
		}
		if(input.length == 1) {
			return new String(input);
		}
		boolean[][] isP = new boolean[input.length][input.length];
		int max = 0, start = 0, end = 0;
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j <= i; j++) {
				isP[i][j] = input[i] == input[j] && (i - j < 2 || isP[i - 1][j + 1]);
					if(isP[i][j] && i - j + 1 > max) {
						max = i - j + 1;
						start = j;
						end = i;
					}
					
			}
		}
		return new String(input).substring(start, end + 1);
	}
	
	private static String longestPalindromicSubsringExpandAroundCenter(char[] input) {
		
		if(input.length <= 0) {
			return new String(input);
		}
		int start = 0, end = 0;
		for(int i = 0; i < input.length; i++) {
			int len1 = expandAroundCenter(input, i, i);
			int len2 = expandAroundCenter(input, i, i + 1);
			int len = Math.max(len1, len2);
			if(len > end - start) {// it's cover both odd and even of len
				start = i - (len - 1) / 2;
				end = i + len / 2; 
			}
		}
		return new String(input).substring(start,end +1);
	}
	
	private static int expandAroundCenter(char[] input, int l, int r) {
		int start = l, end = r;
		while (start >= 0 && end < input.length && input[start] == input[end]) {
			start--;
			end++;
		}
		return end - start - 1;
		// why did not return end - start? we will start from i, try to get the length between i and start, i and end.
	}
}
