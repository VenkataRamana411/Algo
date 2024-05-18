package LeetCode;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        System.out.println(sumOfLeftLeaves(treeNode3));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private static int helper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        System.out.println(node.val);
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }
        int leftSum = helper(node.left, true);
        int rightSum = helper(node.right, false);
        return leftSum + rightSum;
    }
}
