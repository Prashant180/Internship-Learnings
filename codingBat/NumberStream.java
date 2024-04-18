package codingBat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberStream {
    public static void main(String[] args) {
        List<Integer> numList=new ArrayList<>();
        numList.add(3);
        numList.add(38);
        numList.add(16);
        numList.add(24);
        numList.add(13);
        numList.add(13);
        numList.add(11);
        numList.add(22);
        numList.add(22);
        numList.add(38);

        numList.stream().filter(x->x%2==0).forEach(n-> System.out.println(n));
        System.out.println(numList);
        numList.stream().filter(x->x%2!=0).forEach(n-> System.out.println(n));
        System.out.println();
        System.out.println(numList.stream().count());
        System.out.println();
        numList.stream().distinct().forEach(n-> System.out.println(n));
        System.out.println();
        numList.stream().filter(x->x.toString().charAt(0)=='1').forEach(n-> System.out.println(n));
        System.out.println();
        System.out.println(numList.stream().findFirst());
        System.out.println();
        System.out.println(numList.stream().max(Integer::compare));
        System.out.println();
        numList.stream().sorted().forEach(x-> System.out.println(x));
        System.out.println();
        numList.stream().sorted(Comparator.reverseOrder()).forEach(x-> System.out.println(x));

        Map<Integer,Long> repeatElements=numList.stream().collect(Collectors.groupingBy(i->i, Collectors.counting()));
        List<Integer> duplicates = repeatElements.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicates);

        List<String> str=new ArrayList<>();
        str.add("Geeks");
        str.add("For");
        str.add("Geeks");
        str.add("Geeks-For-Geeks");
        System.out.println(str);
        str.stream();
    }
}
