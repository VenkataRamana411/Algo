package LeetCode;

import java.util.Stack;

public class RemoveNodes {
    public static void main(String[] args) {
        ListNode listNode8 = new ListNode(8, null);
        ListNode listNode3 = new ListNode(3, listNode8);
        ListNode listNode13 = new ListNode(13, listNode3);
        ListNode listNode2 = new ListNode(2, listNode13);
        ListNode listNode5 = new ListNode(5, listNode2);
        System.out.println(removeNodes(listNode5));

    }

    public static ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        while (curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        curr = stack.pop();
        int max = curr.val;
        ListNode result = new ListNode(max);
        while (!stack.isEmpty()){
            curr = stack.pop();
            if (curr.val < max){
                continue;
            }else {
                ListNode node = new ListNode(curr.val);
                node.next = result;
                result = node;
                max = node.val;
            }
        }
        return result;
    }

}
