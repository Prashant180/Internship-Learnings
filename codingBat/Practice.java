package codingBat;

import java.util.Collections;
import java.util.LinkedList;

public class Practice {
    public static void main(String[] args) {
        LinkedList<String> animals=new LinkedList<>();
        animals.add("cat");
        animals.add("rabbit");
        animals.add("cow");
        animals.add("dog");

        LinkedList<String> birds=new LinkedList<>();
        birds.add("Sparrow");
        birds.add("Parrot");
        birds.add("Pigeon");



        animals.addAll(birds);

        animals.stream().forEach(e-> System.out.println(e));

        animals.add("Horse");

        System.out.println(animals.removeFirst());

        System.out.println(animals.peekLast());

        for (int i=0;i< animals.size();i++){
            System.out.println("The position of " + animals.get(i) + " is " + i);
        }

        System.out.println();

        Collections.shuffle(animals);

        for (String s: animals) {
            System.out.println(s);
        }

        System.out.println(animals.contains("Sparrow"));

        LinkedList<String> birds2= (LinkedList<String>) birds.clone();

        birds2.set(1,"Peacock");

        for (String s: birds2) {
            System.out.println(s);
        }

        System.out.println(birds.equals(birds2));


    }
}
