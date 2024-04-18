package codingBat;

public class In1to10 {
    public boolean in1To10(int n, boolean outsideMode) {
        if(outsideMode){
            if((n<=1) || (n>=10)){
                return true;
            }
            return false;
        } else if((n>=1) && (n<=10)){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        In1to10 obj=new In1to10();
        System.out.println(obj.in1To10(11,true));
    }
}
