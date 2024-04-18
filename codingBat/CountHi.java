package codingBat;

import java.util.Locale;

public class CountHi {
    public int countHi(String str) {
    int count=0;
    str=str.toLowerCase();
    for (int i=0;i<str.length();i++){
        if (str.charAt(i)=='h' && str.charAt(i+1)=='i'){
            count++;
        }
    }
    return count;
    }
    public static void main(String[] args){
        CountHi obj=new CountHi();
        System.out.println(obj.countHi("ABChi hi"));
    }
}
