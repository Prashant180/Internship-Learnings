package codingBat;

public class DoubleChar {
    public String doubleChar(String str) {
        String result="";
        for (int i=0;i<str.length();i++){
            result = result + str.charAt(i) + str.charAt(i);
        }
        return result;
    }
    public static void main(String[] args){
        DoubleChar obj=new DoubleChar();
        System.out.println(obj.doubleChar("Hi-There"));
    }
}
