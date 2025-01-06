package prep.trees;

public class FindKthSmallest {
    public int count = 0;
    public int result = 0;

    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{20, 8, 22, 1, 9, 12, 10, 14});
        BinarySearchTree.inorderTraversal(bst);
        System.out.println("--------------");
        FindKthSmallest findKthSmallest = new FindKthSmallest();
        System.out.println(findKthSmallest.kthSmallest(bst, 5));
    }

    /**
     * TC: O(K)
     * SC: O(1)
    * */
    public int kthSmallest(Node root, int k) {
        if (k == 1) {
            return root.data;
        }
        findKthSmall(root, k);
        return result;

    }

    private void findKthSmall(Node root, int k) {
        if (root == null) {
            return;
        }
        findKthSmall(root.left, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        findKthSmall(root.right, k);
    }
}
