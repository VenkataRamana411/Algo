package target.linkedlist;

public class ReverseLL {
    public static void main(String[] args) {
        LinkedList.traverse(reverse(LinkedList.getLL()));
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node reverse2(Node head) {
        Node left = null;
        Node right = head;
        Node next;
        while (right != null) {
            next = right.next;
            right.next = left;
            left = right;
            right = next;
        }
        return left;
    }
}
