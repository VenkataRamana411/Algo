package striver.trie;

public class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)) {
                node.put(new Node(), currChar);
            }
            node = node.get(currChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)) {
                return false;
            }
            node = node.get(currChar);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (!node.containsKey(currChar)) {
                return false;
            }
            node = node.get(currChar);
        }
        return true;
    }
}
