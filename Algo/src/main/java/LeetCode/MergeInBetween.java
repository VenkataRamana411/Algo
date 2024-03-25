package LeetCode;

public class MergeInBetween {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode9 = new ListNode(9, listNode5);
        ListNode listNode6 = new ListNode(6, listNode9);
        ListNode listNode13 = new ListNode(13, listNode6);
        ListNode listNode1 = new ListNode(1, listNode13);
        ListNode listNode10 = new ListNode(10, listNode1);

        ListNode listNode102 = new ListNode(1000002, null);
        ListNode listNode101 = new ListNode(1000001, listNode102);
        ListNode listNode100 = new ListNode(1000000, listNode101);
        System.out.println(mergeInBetween(listNode10, 3, 4, listNode100));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int counter = 1;
        ListNode temp = list1;
        ListNode curr = temp;
        while (curr != null && counter < a) {
            counter++;
            curr = curr.next;
        }
        ListNode remove = curr.next;
        curr.next = list2;
        while (curr.next != null) {
            curr = curr.next;
        }
        while (remove != null && counter <= b) {
            counter++;
            remove = remove.next;
        }
        curr.next = remove;
        return temp;
    }
}
