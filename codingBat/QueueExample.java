package codingBat;

import java.util.Iterator;
import java.util.PriorityQueue;

public class QueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> coloursQueue=new PriorityQueue<>();
        coloursQueue.add("Black");
        coloursQueue.add("White");
        coloursQueue.add("Red");
        coloursQueue.add("Blue");

        PriorityQueue<String> colours2=new PriorityQueue<>(coloursQueue);
//        colours2.addAll(coloursQueue);
        System.out.println(colours2);

        System.out.println();
        System.out.println(coloursQueue.equals(colours2));

        System.out.println(coloursQueue);

        System.out.println(coloursQueue.poll());
        System.out.println();

        for (String s : coloursQueue) {
            System.out.println(s);
        }
        System.out.println();
        Object[] colourArray=colours2.toArray();
        for (Object s:colourArray) {
            System.out.println(s);
        }

        String str=coloursQueue.toString();
        System.out.println(str.charAt(7));
    }
}
