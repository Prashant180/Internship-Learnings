package codingBat;

public class GHappy {
    public boolean gHappy(String str) {
        boolean is=false;
        for (int i=0;i<str.length()-1;i++){
            if(str.charAt(i) == 'g'){
                if(str.charAt(i+1) == 'g'){
                    is= !is;
                }
            }
        }
        return is;
    }
    public static void main(String[] args){
        GHappy obj=new GHappy();
        System.out.println(obj.gHappy("xxggyygxx"));
    }
}
