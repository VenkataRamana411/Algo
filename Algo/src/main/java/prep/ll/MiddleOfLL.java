package prep.ll;

public class MiddleOfLL {
    /**
     * 876
     * Given the head of a singly linked list, return the middle node of the linked list.
     * <p>
     * If there are two middle nodes, return the second middle node.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5]
     * Output: [3,4,5]
     * Explanation: The middle node of the list is node 3.
     * Example 2:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5,6]
     * Output: [4,5,6]
     * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [1, 100].
     * 1 <= Node.val <= 100
     */
    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6,null);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        //middleNode(listNode1);
        System.out.println(middleNode(listNode1).val);
    }

    /**
    * TC:O(N)
     * SC:O(1)
    * */
    public static ListNode middleNodeOptimal(ListNode head) {
        //Fast & Slow pointer approach
        //Push slow by 1x and fast by 2x
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    /**
    * TC: O(N) + O(N/2) = O(1.5*N)
     * SC: O(1)
    * */

    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        count = count /2 ;
        while (count-- != 0){
            head = head.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
