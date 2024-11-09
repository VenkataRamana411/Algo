package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestLevel {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        System.out.println(kthLargestLevelSum(treeNode3, 4));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            long currSum = 0;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = nodes.poll();
                currSum += temp.val;
                if (null != temp.left) {
                    nodes.add(temp.left);
                }
                if (null != temp.right) {
                    nodes.add(temp.right);
                }
            }
            pq.add(currSum);
        }
        if (pq.size() < k) {
            return -1;
        }
        while (k-- > 1) {
            pq.poll();
        }
        return pq.poll();
    }

    private static int levelSum(TreeNode root) {
        return 0;
    }
}
