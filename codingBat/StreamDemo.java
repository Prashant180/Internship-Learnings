package codingBat;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
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
//        nums.stream().forEach(n-> System.out.println(n));
    }
}
