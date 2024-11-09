package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestDiverseString {
    public static void main(String[] args) {
//        System.out.println(longestDiverseString(1, 0, 3));
//        System.out.println(longestDiverseString(7, 1, 0));
//        System.out.println(longestDiverseString(4, 4, 3));
//        System.out.println(longestDiverseString(1, 3, 5));
        System.out.println(longestDiverseString2(1, 3, 5));
        System.out.println(longestDiverseString2(1, 1, 7));
    }

    /*public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        priorityQueue.add(new Pair(a, "a"));
        priorityQueue.add(new Pair(b, "b"));
        priorityQueue.add(new Pair(c, "c"));
        String[] strings = new String[a + b + c];
        Arrays.fill(strings, "");
        boolean isFirst = true;
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            String ch = pair.character;
            int freq = pair.freq;
            if (isFirst) {
                int i = 0;
                while (i + 1 < strings.length && freq > 1) {
                    strings[i++] = ch;
                    strings[i++] = ch;
                    i++;
                    freq = freq - 2;
                }
                if (freq > 0 && i < strings.length) {
                    strings[i] = ch;
                }
                isFirst = false;
            } else {
                for (int j = 1; j < strings.length && freq > 0; j++) {
                    if (strings[j].equals("") && !strings[j - 1].equals(ch)) {
                        strings[j] = ch;
                        freq--;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            if (s.equals("")) {
                return sb.toString();
            }
            sb.append(s);
        }
        return sb.toString();
    }*/

    public static String longestDiverseString2(int a, int b, int c) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((x, y) -> y.freq - x.freq);
        priorityQueue.add(new Pair(a, 'a'));
        priorityQueue.add(new Pair(b, 'b'));
        priorityQueue.add(new Pair(c, 'c'));
        StringBuilder sb = new StringBuilder();
        sb.append('d').append('d');
        int idx = 2;
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            int freq = pair.freq;
            char ch = pair.character;
            while (freq > 0 && sb.charAt(idx-2) != ch){
                sb.append(ch);
                idx++;
                freq--;
            }
            if (freq > 0){
                pair.setFreq(freq);
                priorityQueue.add(pair);
            }
        }
        return sb.substring(2,sb.length());
    }

    static class Pair {
        int freq;
        char character;

        public Pair(int freq, char character) {
            this.freq = freq;
            this.character = character;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }

    private static char findMax(int a, int b, int c) {
        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        if (max == a) {
            return 'a';
        } else if (max == b) {
            return 'b';
        } else {
            return 'c';
        }
    }

    private static char findMin(int a, int b, int c) {
        int min = a;
        if (min > b) {
            min = b;
        }
        if (min > c) {
            min = c;
        }
        if (min == a) {
            return 'a';
        } else if (min == b) {
            return 'b';
        } else {
            return 'c';
        }
    }
}
