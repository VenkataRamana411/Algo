package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLL {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode22 = new ListNode(2, listNode2);
        ListNode listNode11 = new ListNode(1, listNode22);
        PalindromeLL palindromeLL = new PalindromeLL();
        System.out.println(palindromeLL.isPalindrome(listNode11));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = reverse(slow);
        ListNode temp1 = head;
        ListNode temp2 = reverseHead;
        while (temp2 != null) {
            if (temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
