package LeetCode;

public class AddOneRowTree {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        TreeNode result = addOneRow(treeNode3, 1, 2);
        System.out.println("");
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1){
            return new TreeNode(val,root,null);
        }
        dfsHelper(root, val, depth, true,null);
        return root;
    }

    private static void dfsHelper(TreeNode node, int val, int depth, boolean isLeft,TreeNode prev) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val, null, null);
            if (isLeft){
                newNode.left = node;
                prev.left = newNode;
            }else {
                newNode.right = node;
                prev.right = newNode;
            }
        }
        if (depth < 1 || node == null) {
            return;
        }
        dfsHelper(node.left, val, depth-1, true,node);
        dfsHelper(node.right, val, depth-1, false,node);
    }
}
