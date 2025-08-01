package target.linkedlist;

public class Partition {
    public static void main(String[] args) {
        ListNode result = partition(LinkedList.arrayToLinkedList(new int[]{1, 4, 3, 2, 5, 2}), 3);
        LinkedList.printList(result);
    }

    public static ListNode partition(ListNode head, int x) {
        //Use Two Dummies and merge them together
        ListNode left = new ListNode(0, null);
        ListNode leftTail = left;
        ListNode right = new ListNode(0, null);
        ListNode rightTail = right;
        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}
