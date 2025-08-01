package target.linkedlist;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode listNode = removeNthFromEnd(LinkedList.arrayToLinkedList(new int[]{1, 2, 3, 4, 5}), 5);
        LinkedList.printList(listNode);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head); //Useful when we want to delete head itself
        ListNode slow = dummy;
        ListNode fast = dummy;
        int counter = 0;
        while(fast.next != null){
            fast = fast.next;
            if (counter >= n){
                slow = slow.next;
            }
            counter++;
        }
        if(slow != null && slow.next != null){
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
