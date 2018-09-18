package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

import entities.ListNode;
import utilities.ListNodeUtil;

public class RemoveDuplicatesFromSortedList_83 {
	@Test
	public void test_removeDuplicatesFromSortedList() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		Assert.assertEquals("1,2,3", ListNodeUtil.print(removeDuplicatesFromSortedList(l1)));
	}
	
	private static ListNode removeDuplicatesFromSortedList(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode res = head;
		while(head != null && head.next != null) {
			if(head != null && head.next != null && head.value == head.next.value) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return res;
	}
}
