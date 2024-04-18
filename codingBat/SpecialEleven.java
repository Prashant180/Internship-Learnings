package codingBat;

public class SpecialEleven {
    public boolean specialEleven(int n) {
        if((n%11)<=1){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        SpecialEleven obj=new SpecialEleven();
        System.out.println(obj.specialEleven(24));
    }
}
