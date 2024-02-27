package prep.ll;

import java.util.Stack;

public class ReverseLL {
    /** 206
     *Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
    * */
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        System.out.println(helper(listNode1));
        //System.out.println(reverseList(listNode1));
        //System.out.println(reverseList2(listNode1));
    }

    /**
     * TC:O(N)
     * SC:O(1)
    * */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            //Move the next pointer step ahead
            next = curr.next;
            //shift the current next pointer from next to prev
            curr.next = prev;
            //Move prev to curr & curr to next
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static ListNode reverseList2(ListNode head){
        ListNode curr = head;
        Stack<ListNode> nodes = new Stack<>();
        while (curr != null){
            nodes.push(curr);
            curr = curr.next;
        }
        ListNode tail = new ListNode(-1);
        curr = tail;
        while (!nodes.isEmpty()){
            curr.next = nodes.pop();
            curr = curr.next;
        }
        curr.next = null;
        return tail.next;
    }

    public static ListNode helper(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
