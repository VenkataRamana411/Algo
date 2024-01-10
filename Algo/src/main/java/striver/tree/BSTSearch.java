package striver.tree;

public class BSTSearch {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(6, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, null);
        TreeNode treeNode4 = new TreeNode(7, treeNode2, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode3, treeNode4);
    }


}
