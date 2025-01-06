package prep.trees;

public class SmallestInBST {
    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{20, 8, 22,1,9, 12, 10, 14});
        //BinarySearchTree.inorderTraversal(bst);
        System.out.println(minValue(bst));
    }

    /**
     * TC: O(N)
     * SC: O(1) - Iterative & O(N) - Recursive
    * */
    private static int minValue(Node root){
        if (root == null){
            return -1;
        }
        if (root.left == null){
            return root.data;
        }
        return minValue(root.left);
    }
    private static int minValueIterative(Node root){
        if (root == null){
            return -1;
        }
        Node temp = root;
        while (temp.left != null){
            temp = temp.left;
        }
        return temp.data;
    }
}
