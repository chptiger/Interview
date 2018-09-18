package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
 * For each integer, you should choose one from + and - as its new symbol.

	Find out how many ways to assign symbols to make sum of integers equal to target S.
	
	Example 1:
	Input: nums is [1, 1, 1, 1, 1], S is 3. 
	Output: 5
	Explanation: 
	
	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	
	There are 5 ways to assign symbols to make the sum of nums be target 3.
	Note:
	The length of the given array is positive and will not exceed 20.
	The sum of elements in the given array will not exceed 1000.
	Your output answer is guaranteed to be fitted in a 32-bit integer.
 * @author xx65
 *
 */
public class TargetSum_494 {
	static int count;
	@Test
	public void test_targetSum() {
		int[] arr = {1, 1, 1, 1, 1};
		Assert.assertEquals(5, targetSumDSF(arr, 3));
	}
	
	private static int targetSumDSF(int[] arr, int target) {
		count(arr, 0, 0, target);
		return count;
	}
	
	/**
	 	we should put count() into the else {}
	 	1. if arr length is 1, there will be ArrayOutOfBoundsException for second count() method

	 	   
	 */
	private static void count_wrong(int[] arr, int index, int sum, int target) {
		if(index == arr.length) {
			if(sum == target) { // if(index == arr.length && sum == target) we could not return in the final level
				count++;
			}
			return;
		} // we should put the follow codes into _lse {}  
		count(arr, index + 1, sum + arr[index], target);
		count(arr, index - 1, sum - arr[index], target); // it should index + 1 	 	2. if arr length larger than 1, there will be StackOverFlowError the method will alwarys run two count() methods.
	}
	
	// if else or add return to make current method complete to avoid StackOverFlowError.
	private static void count(int[] arr, int index, int sum, int target) {
		if (index == arr.length) {
			if (sum == target)
				count++;
			// return; // do not need return statement there. we use if else, the current count method was completed.
		} else {
			count(arr, index + 1, sum + arr[index], target);
			count(arr, index + 1, sum - arr[index], target);
		}
	}
}
