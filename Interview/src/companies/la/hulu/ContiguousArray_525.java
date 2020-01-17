package companies.la.hulu;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray_525 {

	@Test
	public void test_largestSubArraySum() {
		int[] arr = {0,1,1,0,0,0,1};
		System.out.println(findMaxCount(arr));
		System.out.println(findMaxCountConstant(arr));
	}

	/**
	 * Time Complexity: O(n^2)
	 */
	public static int findMaxCount(int[] arr) {
		int count = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			int zeroCount = 0, oneCount = 0;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] == 0) {
					zeroCount++;
				} else {
					oneCount++;
				}
				if(zeroCount == oneCount) {
					count = Math.max(count, zeroCount);
				}
			}
		}
		return count;
	}
	
	/**
	 * Time Complexity: O(n)
	 * https://leetcode.com/problems/subarray-sum-equals-k/solution/?page=2
	 * 
	 */
	public static int findMaxCountConstant(int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap();
		return count;
	}
	
}
