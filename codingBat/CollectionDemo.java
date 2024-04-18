package codingBat;

import java.util.*;
import java.util.List;

public class CollectionDemo {
    public static void main(String[] args) {

//        creating new list and adding colours
        ArrayList<String> colours=new ArrayList<>();
        colours.add("Red");
        colours.add("White");
        colours.add("Green");
        colours.add("Blue");
        colours.stream().forEach(n-> System.out.println(n));

//        ArrayList to array
        Object[] obj=colours.toArray();
        for (Object e: obj) {
            System.out.println(e + " ");
        }

//      array to arraylist
        List<Object> al=Arrays.asList(obj);

//        to reverse a list
        List<Integer> nums= Arrays.asList(4,1,9,4,2,6);
        Collections.reverse(nums);
        System.out.println(nums);

        List<Integer> nums2=new ArrayList<>();
        nums.add(2);
        nums.add(7);
        nums.add(9);
        nums.add(4);
        nums.add(5);
        nums.add(1);

        nums2.add(2);
        nums2.add(7);
        nums2.add(9);
        nums2.add(4);
        nums2.add(5);
        nums2.add(11);

//        comparing two arraylist
        if (nums.equals(nums2)){
            System.out.println("Both are equals");
        } else {
            System.out.println("Not equals");
        }

//        to empty an arraylist
        nums2.clear();

//        to get element at a specified index
        System.out.println(nums.get(2));
        System.out.println();

//        to remove element at specified index
        nums.remove(2);

//        to search an element in an array list
        System.out.println(nums.contains(5));

//        to sort a given arraylist
        Collections.sort(nums);

//        to iterate through all element
        for (int e: nums) {
            System.out.println(e);
        }
        System.out.println();

//        to join two arraylist
        nums.addAll(nums2);
        for (int e: nums) {
            System.out.println(e);
        }
        System.out.println();

//        extracting portion of arraylist
        System.out.println(nums.subList(2,5));
    }
}
