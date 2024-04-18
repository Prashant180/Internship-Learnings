package codingBat;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> names=new HashSet<>();

        names.add("John");
        names.add("Arya");
        names.add("Ned");
        names.add("Sansa");

        System.out.println(names);

        Set<String> names2=new HashSet<>(names);

        System.out.println(names.equals(names2));

        names2.add("Hound");

//        names.clear();

        Iterator<String> namesIterator= names.iterator();
        while (namesIterator.hasNext()){
            System.out.println(namesIterator.next());
        }

        System.out.println(names.size());

        Iterator<String> names2Iterator= names2.iterator();
        while (names2Iterator.hasNext()){
            System.out.println(names2Iterator.next());
        }

        System.out.println();

        names2.retainAll(names);
        System.out.println(names2);

        String[] arr=new String[names2.size()];

        names2.toArray(arr);

        System.out.println();

        for (String name:arr) {
            System.out.println(name);
        }

        Set<String> namesTreeSet = new TreeSet<>(names2);

        System.out.println(namesTreeSet);

        List<String> nameList=new ArrayList<>(names2);
        System.out.println(nameList);

        TreeSet<String> colours=new TreeSet<>();
        colours.add("Blue");
        colours.add("White");
        colours.add("Black");

        NavigableSet<String> reverseColours= colours.descendingSet();

        Iterator<String> coloursIterator=reverseColours.iterator();
        while (coloursIterator.hasNext()){
            System.out.println(coloursIterator.next());
        }

        System.out.println(reverseColours.first());
        System.out.println(reverseColours.last());

        System.out.println(colours.equals(reverseColours));
        TreeSet<Integer> nums=new TreeSet<>();

        nums.add(8);
        nums.add(4);
        nums.add(2);
        nums.add(9);
        nums.add(22);

        nums.pollFirst();
        nums.pollLast();
        nums.remove(9);

        for (Integer n:nums) {
            if (n<7){
                System.out.println(n);
            }
        }

    }
}
