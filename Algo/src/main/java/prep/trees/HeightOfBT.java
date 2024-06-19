package prep.trees;

public class HeightOfBT {
    public static void main(String[] args) {
        Node treeNode5 = new Node(5, null, null);
        Node treeNode4 = new Node(4, null, null);
        Node treeNode3 = new Node(3, null, null);
        Node treeNode2 = new Node(2, treeNode4, treeNode5);
        Node treeNode1 = new Node(1, treeNode2, treeNode3);
        System.out.println(heightOfTree(treeNode1,0));
    }
    private static int heightOfTree(Node root,int height){
        if (root == null){
            return height;
        }
        height++;
        int left = heightOfTree(root.left,height);
        int right = heightOfTree(root.right,height);
        return Math.max(left,right);
    }
}
