package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalDistance {

    public static void main(String[] args) {
//        ListNode listNode7 = new ListNode(7, null);
//        ListNode listNode24 = new ListNode(2, listNode7);
//        ListNode listNode23 = new ListNode(2, listNode24);
//        ListNode listNode22 = new ListNode(2, listNode23);
//        ListNode listNode31 = new ListNode(3, listNode22);
//        ListNode listNode21 = new ListNode(2, listNode31);
//        ListNode listNode2 = new ListNode(2, listNode21);
//        ListNode listNode3 = new ListNode(3, listNode2);
//        ListNode listNode1 = new ListNode(1, listNode3);
        ListNode listNode23 = new ListNode(2, null);
        ListNode listNode22 = new ListNode(1, listNode23);
        ListNode listNode31 = new ListNode(5, listNode22);
        ListNode listNode21 = new ListNode(2, listNode31);
        ListNode listNode2 = new ListNode(1, listNode21);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode1 = new ListNode(5, listNode3);
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(listNode1)));

    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCritical = -1, prevCritical = -1, min = Integer.MAX_VALUE, max = -1;
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int i = 2;
        while (next != null) {
            if (curr.val < prev.val && curr.val < next.val) {
                if (firstCritical == -1) {
                    firstCritical = i;
                }else {
                    min = Math.min(min,i - prevCritical);
                    max = i - firstCritical;
                }
                prevCritical = i;
            } else if (curr.val > prev.val && curr.val > next.val) {
                if (firstCritical == -1) {
                    firstCritical = i;
                }else {
                    min = Math.min(min,i - prevCritical);
                    max = i - firstCritical;
                }
                prevCritical = i;
            }
            prev = curr;
            curr = next;
            next = next.next;
            i++;
        }
        return new int[]{min,max};
    }
}
