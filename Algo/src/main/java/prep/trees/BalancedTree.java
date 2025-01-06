package prep.trees;

public class BalancedTree {

    boolean isBalanced = true;
    public boolean isBalanced(Node root) {
        //check LD & RD at every node
        maxHeight(root);
        return isBalanced;
    }

    private int maxHeight(Node root){
        if(!isBalanced){
            return 0;
        }
        if(root == null){
            return 0;
        }
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        if(Math.abs(leftHeight-rightHeight) > 1){
            isBalanced = false;
        }
        //For every node, we need max of subtree + 1
        return 1 + Math.max(leftHeight,rightHeight);
    }
}
