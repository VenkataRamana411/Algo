package target.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Aquarium<GoldFish> aquarium = new Aquarium<>(new GoldFish(), new GoldFish());
        GoldFish fish1 = aquarium.fish1;
        fish1.swim();

        Aquarium aquarium1 = new Aquarium(new GoldFish(), new StarFish());
        ArrayList<String> list = new ArrayList<>();
        list.add("Ram");
        ArrayList list2 = list;
        list2.add(100);
        System.out.println(list);

        new Sample1<Integer>().show(100);
        new Sample2().show("String");
        Sample2.printItems(new Integer[]{1, 2, 3, 4, 5});
        Sample2.printMultipleItems(0, new Integer[]{1, 2, 3, 4, 5});
    }
}

class Sample2 {
    public <T> void show(T item) {
        System.out.println("Item : " + item);
    }

    public <T> T show2(T item) {
        System.out.println("Item : " + item);
        return item;
    }

    public static <U> void printItems(U[] items) {
        for (U item : items) {
            System.out.println(item);
        }
    }

    public static <U, T> void printMultipleItems(T t, U[] items) {
        for (U item : items) {
            System.out.println(item + ":" + t);
        }
    }

    public <T> T multiParam(T item1, T item2) {
        System.out.println("Item : " + item1);
        return item2;
    }

//    public static <T> T sum(T item1, T item2) {
//        return item1 + item2;
//    }

}

class Sample1<T> {
    public void show(T item) {
        System.out.println("Item : " + item);
    }
}

