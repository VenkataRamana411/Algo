package prep.trees;

public class MirrorTree {
    public static void main(String[] args) {
        Node treeNode4 = new Node(4, null, null);
        Node treeNode3 = new Node(3, null, treeNode4);
        Node treeNode2 = new Node(2);
        Node root1 = new Node(1, treeNode2, treeNode3);

        Node node4= new Node(4);
        Node node3 = new Node(3, node4,null );
        Node node2 = new Node(2);
        Node root2 = new Node(1,node3,node2);
        System.out.println(areMirror(root1,root2));
    }

    /**
     * TC: O(M+N)
     * SC: O(M+N)
    * */

    /**
    * Approach 2: Inorders of A & B will be same in reverse order in case of error
     * Tree 1 : [2 1 3 4]
     * Tree 2:  [4 3 1 2]
    * */
    private static boolean areMirror(Node root1,Node root2){
        //Both Empty - Return true
        if (root1 == null && root2 == null){
            return true;
        }
        // If Either one is empty return false
        if (root1 == null || root2 == null){
            return false;
        }
        //Check root & Switch sides
        if (root1.data != root2.data){
            return false;
        }
        return areMirror(root1.left,root2.right) && areMirror(root1.right,root2.left);
    }

    private static boolean areIdentical(Node root1,Node root2){
        //Both Empty - Return true
        if (root1 == null && root2 == null){
            return true;
        }
        // If Either one is empty return false
        if (root1 == null || root2 == null){
            return false;
        }
        //Check root & Switch sides
        if (root1.data != root2.data){
            return false;
        }
        return areMirror(root1.left,root2.left) && areMirror(root1.right,root2.right);
    }
}
