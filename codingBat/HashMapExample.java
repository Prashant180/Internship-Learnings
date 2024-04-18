package codingBat;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String,Integer> names=new HashMap<>();
        names.put("John",5);
        names.put("Arya",8);
        names.put("Bran",9);
        System.out.println(names.size());

        System.out.println(names);

        HashMap<String,Integer> names2=new HashMap<>();
        names2.putAll(names);
        System.out.println(names2);

        System.out.println(names.containsKey("Arya"));
        System.out.println(names.containsValue(9));

        HashMap<String, Integer> names3=new HashMap<String,Integer>();
        names3= (HashMap) names.clone();

        System.out.println(names3);
        System.out.println(names.keySet());

    }
}
