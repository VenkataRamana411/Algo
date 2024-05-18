package LeetCode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode listNode9 = new ListNode(9, null);
        ListNode listNode1 = new ListNode(1, listNode9);
        ListNode listNode5 = new ListNode(5, listNode1);
        ListNode listNode4 = new ListNode(4, listNode5);
        deleteNode(listNode5);
        System.out.println(listNode4);
    }
    public static void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode next = node.next;
        while(next != null){
            curr.val = next.val;
            curr = next;
            next = next.next;
        }
        node.next = curr;
    }
}
