package prep.trees;

import java.util.ArrayList;
import java.util.List;

public class LargestLessThanK {

    public int largest = 0;

    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{20, 8, 22, 1, 9, 12, 10, 14});
        //BinarySearchTree.inorderTraversal(bst);
        LargestLessThanK largestLessThanK = new LargestLessThanK();
        System.out.println(largestLessThanK.largestLessThanK(bst, 20));
        System.out.println(largestLessThanK.largestLessThanK(bst, 25));
        System.out.println(largestLessThanK.largestLessThanK(bst, 16));
        System.out.println(largestLessThanK.largestLessThanK(bst, 2));
        System.out.println(largestLessThanK.largestLessThanK2(bst, 20));
        System.out.println(largestLessThanK.largestLessThanK2(bst, 25));
        System.out.println(largestLessThanK.largestLessThanK2(bst, 16));
        System.out.println(largestLessThanK.largestLessThanK2(bst, 2));
    }

    public int largestLessThanK(Node root, int k) {
        //largest = 0;
        return traverse2(root, k,0);
        //return largest;
    }

    public int largestLessThanK2(Node root, int k) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        int prev = -1;
        for(Integer num : result){
            if (prev >= k){
                return prev;
            }
            prev = num;
        }
        return 0;
    }

//    private void traverse(Node root, int k) {
//        if (root == null) {
//            return;
//        }
//        if (root.data == k) {
//            largest = k;
//            return;
//        } else if (root.data < k) {
//            largest = Math.max(largest, root.data);
//        }
//        traverse(root.left, k);
//        traverse(root.right, k);
//    }

    private int traverse2(Node root, int k, int closest) {
        if (root == null) {
            return closest;
        }
        if (root.data == k) {
            return k;
        } else if (root.data < k) {
            closest = Math.max(closest, root.data);
        }
        int left = traverse2(root.left, k, closest);
        int right = traverse2(root.right, k, closest);
        return Math.max(left, right);
    }

    private static void inorderHelper(Node root, List<Integer> result) {
        if (root != null) {
            // Traverse the left subtree
            inorderHelper(root.left, result);
            // Visit the node
            result.add(root.data);
            // Traverse the right subtree
            inorderHelper(root.right, result);
        }
    }
}
