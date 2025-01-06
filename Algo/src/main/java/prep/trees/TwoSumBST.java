package prep.trees;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {
    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{15,10,20,8,12,16,24});
        //BinarySearchTree.inorderTraversal(bst);
        List<Integer[]> pairs = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        twoSumInBST(bst,28,pairs,nums);
        for (Integer[] pair : pairs){
            System.out.println("["+pair[0]+","+pair[1]+"]");
        }
    }

    /**
     * TC: O(N)
     * SC: O(N)
    * Best Approach: InOrder Traverse it to create array and use two pointers to find pairs
    * */
    private static void twoSumInBST(Node root, int target, List<Integer[]> pairs, List<Integer> nums){
        if (root == null){
            return;
        }
        if (nums.contains(target-root.data)){
            pairs.add(new Integer[]{target-root.data,root.data});
        }
        nums.add(root.data);
        twoSumInBST(root.left,target,pairs,nums);
        twoSumInBST(root.right,target,pairs,nums);
    }

    private static void twoSumInBST2(Node root, int target){

    }
}
