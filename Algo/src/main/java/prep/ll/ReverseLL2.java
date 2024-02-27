package prep.ll;

public class ReverseLL2 {
    /** 92
     * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5], left = 2, right = 4
     * Output: [1,4,3,2,5]
     * Example 2:
     *
     * Input: head = [5], left = 1, right = 1
     * Output: [5]
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is n.
     * 1 <= n <= 500
     * -500 <= Node.val <= 500
     * 1 <= left <= right <= n
     *
     *
     * Follow up: Could you do it in one pass?
    *
    * */
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        //System.out.println(reverseBetween2(listNode1,2,4));
        System.out.println(helper(listNode1,1,5));
        //System.out.println(reverseList2(listNode1));
    }
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        //Create a dummy node and append it to head. As we need to return the result at the end
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0 ; i < left-1 ; i++){
            prev = prev.next;
        }
        //Iterate prev till it reaches point before reversing window
        ListNode curr = prev.next;
        for (int i = 0 ; i < right-left ; i++){
            //Take next node of current as forward
            ListNode fwd = curr.next;
            curr.next = fwd.next;
            fwd.next = prev.next;
            prev.next = fwd;
        }
        //Finally return from the head
        return dummy.next;
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int idx = 1;
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        ListNode curr = head;
        res.next = head;
        while (idx++ < left){
            prev = prev.next;
            curr = curr.next;
            idx++;
        }
        for (idx = 0 ; idx < right-left ; idx++){
            ListNode dummy = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = dummy;
        }
        return res.next;
    }

    public static ListNode helper(ListNode head, int left, int right){
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        for (int i = 0 ; i < left-1 ; i++){
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode fwd = null;
        while (left++ != right){
            fwd = curr.next;
            curr.next = fwd.next;
            fwd.next = prev.next;
            prev.next = fwd;
        }
        return temp.next;
    }
}
