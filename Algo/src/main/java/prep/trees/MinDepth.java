package prep.trees;

public class MinDepth {

    public static int result = 2000000;

    public static void main(String[] args) {
        Node bst = BinarySearchTree.createBST(new int[]{20, 8, 22, 1, 9, 12, 10, 14});
        System.out.println(minDepth(bst));
    }
    public static int minDepth(Node root) {
        if(root == null){
            return 0;
        }
        traverse(root,1);
        return result;
    }

    private static void traverse(Node root, int depth){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result = Math.min(depth,result);
            return;
        }
        depth++;
        traverse(root.left,depth);
        traverse(root.right,depth);
    }

    public static int minDepth2(Node root) {
        if (root == null){
            return 0;
        }
        return traverse2(root, 1, Integer.MAX_VALUE);
    }

    private static int traverse2(Node root, int currDepth, int minDepth) {
        if (root == null) {
            minDepth = Math.min(currDepth, minDepth);
            return minDepth;
        }
        if (root.left == null && root.right == null) {
            minDepth = Math.min(currDepth, minDepth);
            return minDepth;
        }
        int left = traverse2(root.left, currDepth + 1, minDepth);
        int right = traverse2(root.left, currDepth + 1, minDepth);
        return Math.min(left, right);
    }
}
