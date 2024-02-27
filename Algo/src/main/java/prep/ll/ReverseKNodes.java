package prep.ll;

public class ReverseKNodes {
    /**
     * 25. Reverse Nodes in k-Group
     * Hard
     * Topics
     * Companies
     * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     *
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     *
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     * Example 2:
     *
     *
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is n.
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
    * */

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        System.out.println(reverseKGroup(listNode1,2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode curr = prev.next;
        ListNode fwd = null;
        while (curr.next != null){
            count = 1;
            while (count++ != k){
                fwd = curr.next;
                curr.next = fwd.next;
                fwd.next = curr;
                prev.next = fwd;
            }
            prev = fwd.next;
            curr = prev.next;
            System.out.println(curr);
        }
        return temp.next;
    }
}
