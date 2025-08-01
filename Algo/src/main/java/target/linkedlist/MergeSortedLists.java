package target.linkedlist;

public class MergeSortedLists {
    public static void main(String[] args) {
        Node node5 = new Node(15, null);
        Node node4 = new Node(12, node5);
        Node node3 = new Node(9, node4);
        Node node2 = new Node(5, node3);
        Node node1 = new Node(1, node2);

        Node node55 = new Node(14, null);
        Node node45 = new Node(11, node55);
        Node node33 = new Node(10, node45);
        Node node22 = new Node(8, node33);
        Node node11 = new Node(4, node22);

        LinkedList.traverse(mergeSortedLists(node1, node11));
    }

    public static Node mergeSortedLists(Node list1, Node list2) {
        Node dummy = new Node(-1, null);
        Node curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next; //Current will keep on moving by sorting it one by one
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return dummy.next;
    }
}
