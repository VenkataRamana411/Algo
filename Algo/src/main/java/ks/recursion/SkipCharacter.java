package ks.recursion;

public class SkipCharacter {
    public static void main(String[] args) {
        String s = "ramana";
        System.out.println(helper1(s,"",0));
        String sample = "A ba dfdg dfd sd fdgt sdsd sdds ddfg";
        String[] split = sample.split(" ");
        helper("","Venkata Ramana");
    }
    private static String helper1(String s,String result,int index){
        if (s.length() == index){
            return result;
        }
        if (s.charAt(index) != 'a'){
            result += s.charAt(index);
        }
        return helper1(s,result,index+1);
    }
    private static void helper(String result,String s){
        if (s.isEmpty()){
            System.out.println(result);
            return;
        }
        char ch = s.charAt(0);
        if (ch == 'a'){
            helper(result,s.substring(1));
        }else {
            helper(result+ch,s.substring(1));
        }
    }
    private static void skipString(){

    }
}
