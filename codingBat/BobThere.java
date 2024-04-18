package codingBat;

public class BobThere {
    public boolean bobThere(String str) {
        for (int i=0;i<str.length()-2;i++){
            if (str.charAt(i)=='b' && str.charAt(i+2)=='b'){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        BobThere obj=new BobThere();
        System.out.println(obj.bobThere("b9b"));
    }

}
