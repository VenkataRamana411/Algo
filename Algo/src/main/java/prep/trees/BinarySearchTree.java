package prep.trees;

class BinarySearchTree {
    static Node root;

    // Method to insert a new value into the BST
    public static Node insert(Node root, int value) {
        // If the tree is empty, return a new node
        if (root == null) {
            return new Node(value);
        }

        // Otherwise, recur down the tree
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to create the BST from an array
    public static Node createBST(int[] arr) {
        for (int value : arr) {
            root = insert(root, value);
        }
        return root;
    }

    // In-order traversal to print the BST (sorted order)
    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
}