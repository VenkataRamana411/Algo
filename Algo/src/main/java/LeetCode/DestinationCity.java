package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public static void main(String[] args) {

    }

    public static String destCity(List<List<String>> paths) {
        List<String> countries = new ArrayList<>();
        for (List<String> path : paths) {
            if (countries.contains(path.get(0))) {
                countries.remove(path.get(0));
            } else {
                countries.add(path.get(0));
            }
            if (countries.contains(path.get(1))) {
                countries.remove(path.get(1));
            } else {
                countries.add(path.get(1));
            }
        }
        return countries.get(0);
    }
}
