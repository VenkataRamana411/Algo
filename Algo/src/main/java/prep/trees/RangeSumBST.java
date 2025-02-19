package prep.trees;

public class RangeSumBST {
    public int result = 0;

    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{20, 8, 22, 1, 9, 12, 10, 14});
        BinarySearchTree.inorderTraversal(bst);
        RangeSumBST differenceBST = new RangeSumBST();
        System.out.println(differenceBST.rangeSumBST(bst, 9, 15));
    }

    public int rangeSumBST(Node root, int low, int high) {
        traverse(root, low, high);
        return result;
    }

    private void traverse(Node root, int low, int high) {
        {
            if (root == null) {
                return;
            }
            traverse(root.left, low, high);
            if (root.data >= low && root.data <= high) {
                result += root.data;
            }
            traverse(root.right, low, high);
        }
    }
}
