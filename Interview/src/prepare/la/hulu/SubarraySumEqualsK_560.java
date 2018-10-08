package prepare.la.hulu;

import org.junit.Test;

/*
 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
 */
public class SubarraySumEqualsK_560 {

	@Test
	public void test_largestSubArraySum() {
		int[] arr = { 2, 4, -1, -3, 5, 7, 9, -3 };
		int target = 13;
		System.out.println(findIndexSubarray(arr, target));
	}

	public static int findIndexSubarray(int[] arr, int target) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
				int sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if(sum == target) {
					count++;
				}
			}
		}
		return count;
	}
}
