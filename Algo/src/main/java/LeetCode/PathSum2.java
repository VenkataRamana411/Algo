package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        System.out.println(pathSum(treeNode3,12));
    }

    static List<List<Integer>> paths = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfsHelper(root, targetSum, 0, new ArrayList<>());
        return paths;
    }

    private static void dfsHelper(TreeNode node, int targetSum, int pathSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        pathSum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && targetSum == pathSum) {
            paths.add(new ArrayList<>(path));
        } else {
            dfsHelper(node.left, targetSum, pathSum, path);
            dfsHelper(node.right, targetSum, pathSum, path);
        }
        pathSum -= node.val;
        path.remove(path.size() - 1);
    }
}
