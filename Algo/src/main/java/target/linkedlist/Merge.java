package target.linkedlist;

public class Merge {
    public static void main(String[] args) {

    }

    public Node mergeInBetween(Node list1, int a, int b, Node list2) {
        int counter = 0;
        Node curr = list1;
        while (curr != null && counter < a) {
            curr = curr.next;
            counter++;
        }
        Node temp = curr;
        while (temp != null && counter < b) {
            temp = temp.next;
        }
        curr.next = list2;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return list1;
    }
}
