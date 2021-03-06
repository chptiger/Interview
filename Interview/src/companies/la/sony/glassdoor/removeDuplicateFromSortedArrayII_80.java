package companies.la.sony.glassdoor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length. Example 2:
 * 
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * 
 * Your function should return length = 7, with the first seven elements of nums
 * being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * 
 * It doesn't matter what values are set beyond the returned length.
 * 
 * @author xx65
 *
 */
public class removeDuplicateFromSortedArrayII_80 {

	@Test
	public void test_removeDuplciateFromSortedArray() {
		int[] arr = { 1, 1, 2 };
		Assert.assertEquals(3, removeDuplicateFromSortedArray(arr));
	}

	private static int removeDuplicateFromSortedArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		int i = 0;
		for (int num : arr) {
			if (i < 2 || num > arr[i - 2]) {
				// arr[i++] = arr[i];// ArrayINdexOutOfBoundsException for last index.
				arr[i++] = num;
			}
		}
		return i;
	}

}
