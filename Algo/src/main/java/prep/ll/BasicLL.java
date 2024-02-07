package prep.ll;

public class BasicLL {
    public static void main(String[] args) {

        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        printList(node1);
        printListRecursion(node1);
        lengthOfLL(node1);
        System.out.println(searchInLL(node1,4));
        System.out.println(searchInLL(node1,40));
        System.out.println(printKthNode(node2,2));
    }
    private static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    private static void printListRecursion(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.data + " -> ");
        printListRecursion(head.next);
    }
    private static void lengthOfLL(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println();
        System.out.println(count);
    }

    private static boolean searchInLL(Node head,int target){
        Node temp = head;
        while (temp != null){
            if (temp.data == target){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    private static int printKthNode(Node head,int k){
        Node temp = head;
        while (temp != null){
            if (--k == 0){
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }
}
