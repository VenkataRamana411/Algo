package LeetCode;

public class PathSum {
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, null);
        System.out.println(hasPathSum(null,2));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfsHelper(root,targetSum,0);
    }
    private static boolean dfsHelper(TreeNode node, int targetSum,int pathSum){
        if(node == null){
            return false;
        }
        pathSum += node.val;
        if(node.left == null && node.right == null){
            return targetSum == pathSum;
        }
        return dfsHelper(node.left,targetSum,pathSum) || dfsHelper(node.right,targetSum,pathSum);
    }
}
