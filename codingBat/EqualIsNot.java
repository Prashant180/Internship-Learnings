package codingBat;

public class EqualIsNot {
    public boolean equalIsNot(String str) {
        int is=0;
        int not=0;
        str=str.toLowerCase();
        for (int i=0;i<str.length()-2;i++){
            if(str.substring(i,i+2).equals("is")){
                is++;
            } else if(str.substring(i,i+3).equals("not")){
                not++;
            }
        }
        if(str.length() >= 2 && str.substring(str.length() - 2).equals("is")){
            is++;
        }

        System.out.println(is);
        System.out.println(not);
        if(is==not){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
            EqualIsNot obj=new EqualIsNot();
        System.out.println(obj.equalIsNot("This is notnot"));
    }
}
