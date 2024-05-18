package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SmallestFromLeaf {
    public static void main(String[] args) {
        TreeNode treeNode15 = new TreeNode(15, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        SmallestFromLeaf smallest = new SmallestFromLeaf();
        System.out.println(smallest.smallestFromLeaf(treeNode3));
    }
    String res="";
    public String smallestFromLeaf(TreeNode root) {
        traversal(root,new StringBuilder());
        return res;
    }
    public void traversal(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.insert(0,(char)(root.val+97));
        if(root.left==null&&root.right==null){
            if(res.equals("")){
                res=sb.toString();
            }
            else{
                res=res.compareTo(sb.toString())>0?sb.toString():res;
            }
        }
        traversal(root.left,sb);
        traversal(root.right,sb);
        sb.deleteCharAt(0);
    }

    Map<Integer,Character> charMap = new HashMap<>();
    public String smallestFromLeaf2(TreeNode root) {
        int i = 0;
        for (char c = 'a' ; c <= 'z' ; c++){
            charMap.put(i++,c);
        }
        return dfsHelper(root,"","");
    }
    private String dfsHelper(TreeNode node,String curr,String result){
        if (node == null){
            return result;
        }
        curr = charMap.get(node.val) + curr;
        if (node.left == null && node.right == null){
            if (result.isEmpty()){
                return curr;
            }
            result = lexicographicComparator(curr,result);
            return result;
        }
        String leftString = dfsHelper(node.left, curr, result);
        String rightString = dfsHelper(node.right, curr, result);
        return lexicographicComparator(leftString,rightString);
    }
    private String lexicographicComparator(String s1, String s2){
        if (s1.length() != s2.length()){
            return s1.length() < s2.length() ? s1 : s2;
        }
        return s1.compareTo(s2) < 0 ? s1 : s2;
    }
}
