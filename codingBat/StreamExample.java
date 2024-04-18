package codingBat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>();
        names.add("Tom");
        names.add("Jerry");
        names.add("Ben");
        names.add("Arya");
        names.add("John");
        names.add("Bran");
        names.add("Hound");
        names.add("Sansa");
//        names.add("Sansa ");

        names.stream().filter(s->s.startsWith("B")).filter(l->l.length()>=4).forEach(n-> System.out.println(n));
        System.out.println();
        names.stream().filter(s->s.contains("an")).filter(s->!s.contains(" ")).forEach(n-> System.out.println(n));
        System.out.println();
        System.out.println(names.stream().reduce((str1,str2)->str1+"|"+str2));

        List<Integer> numList=new ArrayList<>();
        numList.add(12);
        numList.add(21);
        numList.add(98);
        numList.add(56);
        numList.add(-36);
        numList.add(-16);
        numList.add(88);
        numList.add(72);
        numList.add(101);
        numList.stream().filter(n->n>50 && n<100).forEach(n-> System.out.println(n));
        System.out.println();
        numList.stream().filter(n->n%2==0).forEach(n-> System.out.println(n));
        System.out.println();
        numList.stream().filter(n->n%2!=0).forEach(n-> System.out.println(n));
        System.out.println();
        numList.stream().filter(n->n>=0).forEach(n-> System.out.println(n));
        System.out.println();
        numList.stream().filter(n->n<=0).forEach(n-> System.out.println(n));
        System.out.println();
        System.out.println(numList.stream().reduce(0,(ans,i)->ans+i));
        Set<Integer> square=numList.stream().map(x->x*x).collect(Collectors.toSet());

        System.out.println(square);
    }
}
