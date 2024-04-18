package codingBat;

public class Old35 {
    public boolean old35(int n) {
        if((n%3)==0 && (n%5)==0){
            return false;
        }else if((n%3)==0 || (n%5)==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Old35 obj=new Old35();
        System.out.println(obj.old35(18));
    }
}
