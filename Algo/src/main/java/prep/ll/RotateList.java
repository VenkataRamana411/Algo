package prep.ll;

public class RotateList {
    /**
     * 61. Rotate List
     * Medium
     * Given the head of a linked list, rotate the list to the right by k places.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     * Example 2:
     * <p>
     * <p>
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [0, 500].
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     */
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(rotateRight(listNode1, 2));
        int n = 15;
        String s = (n % 3 == 0 ? "wal" : "") + (n % 5 == 0 ? "mart" : "");
        System.out.println(s);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 1;
        //Find length of LL
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        if (k == length) {
            return head;
        }
        k = k % length;
        //Make LL Circular
        tail.next = head;
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }
        //head - 4 -> 5 -> tail
        head = tail.next;
        //1 -> 2 -> 3 -> null
        tail.next = null;
        return head;
    }
    /*public static ListNode rotateRight(ListNode head, int k) {
        int length = 1;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            length++;
        }
        if (k == length){
            return head;
        }
        int freq = (k > length) ? k % length : k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 1 ; i < length-freq;i++){
            curr = curr.next;
        }
        curr = curr.next;
        ListNode prev = null;
        ListNode next = null;
        while (freq-- != 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        prev.next = head;
        curr.next = prev;
        return curr;
    }*/
}
