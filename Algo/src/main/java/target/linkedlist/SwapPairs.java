package target.linkedlist;

public class SwapPairs {
    public static void main(String[] args) {
        LinkedList.traverse(swapPairs(LinkedList.getLL()));
    }

    public static Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(0, null);
        Node prev = dummy;
        Node first = head;
        Node second;
        while (first != null && first.next != null) {
            second = first.next;
            prev.next = second; //Update dummy to point new head. i.e Second element
            first.next = second.next; // Update 1st to point to 3rd
            second.next = first; // finally update second to point 1st
            prev = first;
            first = first.next;
        }
        return dummy.next;
    }
}
