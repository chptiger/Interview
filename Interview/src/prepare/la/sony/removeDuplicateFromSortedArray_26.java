package prepare.la.sony;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class removeDuplicateFromSortedArray_26 {

		@Test
		public void test_removeDuplciateFromSortedArray() {
			int[] arr = {1, 1, 2};
			Assert.assertEquals(2, removeDuplicateFromSortedArray(arr));
			Assert.assertEquals(2, removeDuplicateFromSortedArray_TwoPointer(arr));
		}
		
		private static int removeDuplicateFromSortedArray(int[] arr) {
			if(arr == null || arr.length == 0) {
				return 0;
			}
			
			Set<Integer> tmp = new HashSet<Integer>();
			for(int a : arr) {
				tmp.add(a);
			}
			return tmp.size();
		}
		
		private static int removeDuplicateFromSortedArray_TwoPointer(int[] arr) {
			if(arr == null || arr.length == 0) {
				return 0;
			}
			
			int i = 0;
			for(int j = 1; j < arr.length; j++) {
				if(arr[i] != arr[j]) {
					i++;
					arr[i] = arr[j];
				}
			}
			return i + 1;
		}
}
