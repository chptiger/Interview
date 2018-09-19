package utilities;

import entities.ListNode;

public class ListNodeUtil {

	public static String print(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.value + ",");
			head = head.next;
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
}
