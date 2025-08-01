package target.linkedlist;

public class LinkedList {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        deleteNode(node1, 3);
        traverse(node1);
    }

    public static Node getLL() {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        return node1;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void traverse(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static void deleteNode(Node head, int val) {
        Node curr = head;
        Node prev = head;
        while (curr != null) {
            if (curr.data == val) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
