package prepare.la.sony;

import org.junit.Assert;
import org.junit.Test;

import entities.ListNode;
import utilities.ListNodeUtil;

public class RemoveDuplicatesFromSortedListII_82 {

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
		Assert.assertEquals("2,3", ListNodeUtil.print(removeDuplicatesFromSortedList(l1)));
	}

	private static ListNode removeDuplicatesFromSortedList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode pre = new ListNode(-1);
		ListNode res = pre;
		pre.next = head;
		while (head != null && head.next != null) {
			if (head.value == head.next.value) {
				while (head != null && head.next != null && head.value == head.next.value) {
					head = head.next;
				}
				head = head.next;
				pre.next = head;
			} else {
				head = head.next;
				pre = pre.next;
			}
		}
		return res.next;
	}
}
