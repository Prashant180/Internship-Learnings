package codingBat;

public class EndOther {
    public boolean endOther(String a, String b) {
        a=a.toLowerCase();
        b=b.toLowerCase();
        if(a.length()>b.length()){
            if(a.substring(a.length()-b.length()).equals(b)){
                return true;
            }
        } else if(b.length()>a.length()){
            if(b.substring(b.length()-a.length()).equals(a)){
                return true;
            }
        } else if(a.length()==b.length()){
            if(a.equals(b)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        EndOther obj=new EndOther();
        System.out.println(obj.endOther("abc","aBc"));
    }
}
