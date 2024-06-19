package LeetCode;

public class ReplaceWords {
    public static void main(String[] args) {
        String sentence = "the cattle was rattled by the battery";
        System.out.println(sentence.contains("cat"));
        System.out.println(sentence.replaceAll("cat*","cat"));
    }

}
