package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

	For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
	    ...
	Example 1:
	
	Input: 1
	Output: "A"
	Example 2:
	
	Input: 28
	Output: "AB"
	Example 3:
	
	Input: 701
	Output: "ZY"
	
	AAA
	1 + 26 * 1 + 26 * 26 = 703
	
	BAB
	2 + 26^1 + 26^2 * 2
 * @author xx65
 *
 */
public class ExcelSheetColumnTitle_168 {
	
	public static final int count = 26;
	@Test
	public void test_excelSheetColumnTitle() {
		Assert.assertEquals("ZY", getColumnTitle(701));
	}
	/**
	 * The remainder / Modulo:
	 * step 1: 
	 *  num = 700;
	 *  24 = num % 26
	 *  'A' + 24 = 'Y'
	 *  
	 *   num = num / 26 = 26;
	 *   'A' = 25 = 'Z'
	 *   
	 *   ZY
	 *   
	 *   Why num--?
	 *   	because even the current digit is 26, it should not have a carry 1 to the next digit. e.g. 52 -> AZ not BZ.
			(n - 1) makes it 52/26 = 2 (represents 'B') -> BZ ->false
			--n makes it 51/26 = 1 (represents 'A') -> AZ -> true
 *  	 Why use stringbuilder insteadof string?
	 *  	 every time using "+" operation for a string, a new memory space is allocated and a new string is created. 
	 *  	 Using stringbuilder is more efficient both in time and space
	 */
	private static String getColumnTitle(int num) {
		
		StringBuilder sb = new StringBuilder();
		while( num > 0) {
			num--;
			sb.insert(0, (char)('A' + num % 26));
			num = num / count;
		}
		return sb.toString();
	}
}
