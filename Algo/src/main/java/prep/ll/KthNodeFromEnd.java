package prep.ll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KthNodeFromEnd {
    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        System.out.println(helper_1(node1,3));
        System.out.println(helper(node1,3));
    }
    /**
     * TC:O(N)
     * SC:O(1)
    * */
    private static int helper(Node head,int k){
        /**
         * Fast & Slow Pointers
         * Keep slow and fast at a distance of k then traverse
         * till fast reaches end to get slow as kth from last
         * */
       Node slow = head;
       Node fast = head;
       int count = 0;
       while (fast != null && count++ != k){
           fast = fast.next;
       }
       while (fast != null){
           fast = fast.next;
           slow = slow.next;
       }
        return slow.data;
    }

    /**
    * TC: O(N)
     * SC:O(N)
    * */
    private static int helper_1(Node head,int k){
        Map<Integer,Integer> hmap = new HashMap<>();
        int index = 1;
        Node temp = head;
        while (temp != null){
            hmap.put(index++,temp.data);
            temp = temp.next;
        }
        return hmap.getOrDefault(index-k,-1);
    }
}
