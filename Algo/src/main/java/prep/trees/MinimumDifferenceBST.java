package prep.trees;

public class MinimumDifferenceBST {

    public int prev = Integer.MAX_VALUE;
    public int curr = 0;
    public int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{20, 8, 22, 1, 9, 12, 10, 14});
        MinimumDifferenceBST differenceBST = new MinimumDifferenceBST();
        System.out.println(differenceBST.getMinimumDifference(bst));
    }
    public int getMinimumDifference(Node root) {
        traverse(root);
        return result;
    }
    private void traverse(Node root){{
        if (root == null){
            return;
        }
        result = Math.min(result,Math.abs(prev-root.data));
        prev = root.data;
        traverse(root.left);
        traverse(root.right);
    }

    }
}
