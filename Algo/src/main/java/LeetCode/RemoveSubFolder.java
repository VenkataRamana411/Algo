package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFolder {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/f"};
        System.out.println(removeSubfolders(folder));
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : folder) {
            String[] temp = s.split("/");
            int i = 1;
            for (; i < temp.length; i++) {
                sb = sb.append("/").append(temp[i]);
                if (result.contains(sb.toString())) {
                    break;
                }
            }
            if (i == temp.length) {
                result.add(s);
            }
            sb.delete(0, sb.length());
        }
        return result;
    }
}
