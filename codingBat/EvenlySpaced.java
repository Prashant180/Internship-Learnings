package codingBat;

import java.util.Scanner;

public class EvenlySpaced {
    public boolean evenlySpaced(int a,int b,int c){
        if ((a-b)==(b-c)){
            return true;
        } else if ((a-c)==(c-b)){
            return true;
        } else if((c-a)==(a-b)){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        EvenlySpaced obj=new EvenlySpaced();
        System.out.println(obj.evenlySpaced(10,9,11));
    }
}
