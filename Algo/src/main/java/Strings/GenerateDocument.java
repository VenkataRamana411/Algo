package Strings;

import java.sql.Array;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    public static void main(String[] args) {
        System.out.println(generateDocument("Bste!hetsi ogEAxpelrt x ","AlgoExpert is the Best!"));
        System.out.println(generateDocumentOptimal("A","a"));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("ffhgdh");
        sb.reverse();


    }
    public static boolean generateDocument(String characters, String document) {
        if(document.length() == 0){
            return true;
        }
       char[] chars1 =  characters.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 =  document.toCharArray();
        Arrays.sort(chars2);

        if(chars1.length == chars2.length) {
            return Arrays.toString(chars1).equals(Arrays.toString(chars2));
        }else
            {
            int i = 0;
            for (char c:chars1) {
                if(c == chars2[i]){
                    ++i;
                    if(i == chars2.length){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    public static boolean generateDocumentOptimal(String characters, String document) {
        /*if(document.length() == 0){
            return true;
        }*/
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < characters.length();i++ ){
            char temp = characters.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }
        for(int i = 0 ; i < document.length() ; i++){
            char temp = document.charAt(i);
            if(!map.containsKey(temp) || map.get(temp) == 0){
                return false;
            }else {
                map.put(temp,map.get(temp)-1);
            }
        }
       return true;
    }
}
