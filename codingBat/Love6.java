package codingBat;

public class Love6 {
    public boolean love6(int a, int b) {
        if((a==6) || (b==6)){
            return true;
        } else if (((a+b)==6) || ((Math.abs(a-b))==6)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Love6 obj=new Love6();
        System.out.println(obj.love6(4,5));
    }
}
