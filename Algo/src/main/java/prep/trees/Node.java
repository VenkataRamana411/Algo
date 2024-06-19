package prep.trees;

public class Node {
    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
