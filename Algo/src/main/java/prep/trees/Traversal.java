package prep.trees;

public class Traversal {
    public static void main(String[] args) {
        Node treeNode5 = new Node(5, null, null);
        Node treeNode4 = new Node(4, null, null);
        Node treeNode3 = new Node(3, null, null);
        Node treeNode2 = new Node(2, treeNode4, treeNode5);
        Node treeNode1 = new Node(1, treeNode2, treeNode3);
        inOrder(treeNode1);
        System.out.println("---------------");
        preOrder(treeNode1);
        System.out.println("---------------");
        postOrder(treeNode1);
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }
}
