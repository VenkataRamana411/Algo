package prep.ll;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,null);
        ListNode listNode1 = new ListNode(1,listNode2);
        System.out.println(removeNthFromEnd(listNode1,2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //Start node will be useful in cases where we need to remove head itself
        ListNode start = new ListNode();
        start.next = head;
        ListNode fwd = start;
        ListNode curr = start;
        while(n-- != 0){
            fwd = fwd.next;
        }
        while(fwd.next != null){
            fwd = fwd.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return start.next;
    }
}
