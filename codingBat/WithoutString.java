package codingBat;

public class WithoutString {
    public String withoutString(String base, String remove) {
        int len=remove.length();
        String newString="";
        for (int i=0;i<base.length();i++){
            if (base.substring(i,i+len).equals(remove)){
                newString= base.substring(0,i) + base.substring(i+len);
            }
        }
        return base;
    }
    public static void main(String[] args){
        WithoutString obj=new WithoutString();
        System.out.println(obj.withoutString("Hello there", "the"));
    }
}
