package prep.trees;

public class Traversal {
    public static void main(String[] args) {


        Node treeNode5 = new Node(5);
        Node treeNode4 = new Node(4);
        Node treeNode2 = new Node(2, treeNode4, treeNode5);
        Node treeNode3 = new Node(3);
        Node treeNode1 = new Node(1, treeNode2, treeNode3);
        inOrder(treeNode1);
        System.out.println("---------------");
        preOrder(treeNode1);
        System.out.println("---------------");
        postOrder(treeNode1);
        System.out.println("---------------");
        levelOrder(treeNode1);
    }

    //Left -> Root -> Right
    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String s = "";
        s.endsWith("");
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    // Root -> Left -> Right
    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Left -> Right -> Root
    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

    private static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        if (root.left != null){
            System.out.println(root.left.data + " ");
        }
        if (root.right != null){
            System.out.println(root.right.data + " ");
        }
        levelOrder(root.left);
        levelOrder(root.right);
    }
}
