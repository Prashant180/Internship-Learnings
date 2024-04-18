package codingBat;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

class Animals{
    String name;
    Integer number;

    public Animals(String name, Integer number){
        this.name=name;
        this.number=number;
    }

    public String toString(){
        return this.name + " " + this.number;
    }

}

class SortByNumber implements Comparator<Animals>{
    public int compare(Animals a, Animals b){
        return a.name.length()-b.name.length();
    }
}

public class TreeMapExample {

    static void animalConstructor(){
        TreeMap<Animals,Integer> animals2=new TreeMap<Animals,Integer>(new SortByNumber());
        animals2.put(new Animals("Lion",8),1);
        animals2.put(new Animals("Leopard",4),1);
        animals2.put(new Animals("Elephant",10),1);
        animals2.put(new Animals("Monkey",3),1);

        System.out.println(animals2.keySet());
    }
    public static void main(String[] args) {

        animalConstructor();
        System.out.println();

        TreeMap<String,Integer> animalsTreeMap=new TreeMap<>();
        animalsTreeMap.put("Lion", 5);
        animalsTreeMap.put("Leopard", 8);
        animalsTreeMap.put("Elephant",4);

        System.out.println(animalsTreeMap);
        animalsTreeMap.put("Elephant",5);
        System.out.println(animalsTreeMap);

        TreeMap<String,Integer> zooTreeMap= new TreeMap<>();
        zooTreeMap.putAll(animalsTreeMap);
        zooTreeMap.put("Monkey",4);
        System.out.println(zooTreeMap);

        System.out.println(zooTreeMap.containsKey("Monkey"));

        System.out.println(zooTreeMap.keySet());
        System.out.println(zooTreeMap.values());

        System.out.println(zooTreeMap.headMap("Lion"));
        System.out.println(zooTreeMap.floorEntry("Lion"));
//        System.out.println(zooTreeMap.descendingMap());
        System.out.println(zooTreeMap.higherEntry("L"));

        NavigableSet<String> names=zooTreeMap.descendingKeySet();

        System.out.println(zooTreeMap.subMap("E","M"));

        System.out.println(zooTreeMap.pollFirstEntry());
        System.out.println(zooTreeMap.pollLastEntry());

        System.out.println(names);

        zooTreeMap.clear();
        System.out.println(zooTreeMap);
    }
}
