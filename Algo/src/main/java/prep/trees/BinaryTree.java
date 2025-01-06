package prep.trees;

class BinaryTree {
    Node root;

    // Method to create a binary tree from an array
    public Node createBinaryTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Initialize the root of the binary tree
        root = new Node(arr[0]);

        // Use a queue for level-order insertion (BFS)
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        int i = 1;

        // Build the binary tree
        while (i < arr.length) {
            Node current = queue.poll();

            // Add the left child
            if (i < arr.length) {
                current.left = new Node(arr[i++]);
                queue.offer(current.left);
            }

            // Add the right child
            if (i < arr.length) {
                current.right = new Node(arr[i++]);
                queue.offer(current.right);
            }
        }

        return root;
    }
}