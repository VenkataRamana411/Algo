package striver.trie;

public class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(Node node, char ch) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}
