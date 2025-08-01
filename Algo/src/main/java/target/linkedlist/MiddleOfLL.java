package target.linkedlist;

public class MiddleOfLL {
    public static void main(String[] args) {
        LinkedList.traverse(middle(LinkedList.getLL()));
    }

    private static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) { //To reach either null or 1 node before null
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
