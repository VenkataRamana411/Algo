package LeetCode;

public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        System.out.println(sumNumbers(treeNode3));
    }

    public static int sumNumbers(TreeNode root) {
        return helper(root, "");
    }
    private static int helper(TreeNode node, String sum) {
        sum += node.val;
        if (node.left == null && node.right == null){
            return Integer.parseInt(sum);
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }

//    private static int helper(TreeNode node, int sum) {
//        sum += node.val;
//        if (node.left == null && node.right == null){
//            return sum;
//        }
//        return helper(node.left, sum) + helper(node.right, sum);
//    }
}
