package codingBat;

import java.util.LinkedList;

public class Swap {
    public static void main(String[] args) {
        LinkedList<Integer> nums=new LinkedList<>();
        nums.add(2);
        nums.add(1);
        nums.add(23);
        nums.add(14);
        nums.add(11);

//        elements to swap
        int element1 =23;
        int element2 =14;

        System.out.println("Linked list before swapping");
        for (int i:nums) {
            System.out.println(i+" ");
        }

        swap(nums,23,14);
        System.out.println();
        System.out.println("After swapping");

        nums.add(2,22);

        for (int i:nums) {
            System.out.println(i +" ");
        }
    }

    public static void swap(LinkedList<Integer> list, int element1, int element2){
        int index1=list.indexOf(element1);
        int index2=list.indexOf(element2);

        if(index1== -1 || index2== -1){
            return;
        }

        list.set(index1,element2);
        list.set(index2,element1);
    }
}
