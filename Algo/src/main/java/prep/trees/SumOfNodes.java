package prep.trees;

public class SumOfNodes {
    public static void main(String[] args) {
        Node treeNode4 = new Node(4, new Node(5), null);
        Node treeNode3 = new Node(3, null, treeNode4);
        Node treeNode2 = new Node(2);
        Node root1 = new Node(1, treeNode2, treeNode3);
        System.out.println(sumOfTree(root1));
        System.out.println(leftSumOfTree(root1,true));
        System.out.println(rightSumOfTree(root1));
    }
    private static int sumOfTree(Node root){
        if (root == null){
            return 0;
        }
        return root.data + sumOfTree(root.left) + sumOfTree(root.right);
    }


    private static int leftSumOfTree(Node root,boolean isLeft){
        if (root == null){
            return 0;
        }
//        if (isLeft){
//            return root.data + leftSumOfTree(root.left,true) + leftSumOfTree(root.right,false);
//        }
        return (isLeft ? root.data : 0) + leftSumOfTree(root.left,true) + leftSumOfTree(root.right,false);
    }

    /**
     * TC : Depends on Structure
     *  Full Binary Tree : O(log N) as we are eliminating half at every node
     *  Skewed Trees: O(N) as all nodes are present in single side
     * */
    private static int rightSumOfTree(Node root){
        if (root == null){
            return 0;
        }
        return root.data + rightSumOfTree(root.right);
    }
}
