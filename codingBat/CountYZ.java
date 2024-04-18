package codingBat;

import java.util.Locale;

public class CountYZ {
    public int countYZ(String str) {
        int count=0;
        str=str.toLowerCase();
        for (int i=0;i<str.length()-1;i++){
            if((str.charAt(i) == 'y') || (str.charAt(i) == 'z')){
                if (!Character.isLetter(str.charAt(i+1))) {
                    count++;
                }
            }
        }
        if((str.charAt(str.length()-1)) == 'y' || (str.charAt(str.length()-1)) == 'z'){
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        CountYZ obj=new CountYZ();
        System.out.println(obj.countYZ("!!day--yaz!!"));
    }
}
