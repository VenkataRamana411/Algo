package target.linkedlist;

public class CycleDetection {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

    }

    private static Boolean middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) { //To reach either null or 1 node before null
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return true;
    }


}
