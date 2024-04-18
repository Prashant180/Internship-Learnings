package codingBat;

public class CatDog {
    public boolean catDog(String str) {
        int cat=0;
        int dog=0;

        for (int i=0;i<str.length()-2;i++){
            if(str.substring(i,i+3).equals("cat")){
                cat++;
            }else if (str.substring(i,i+3).equals("dog")){
                dog++;
            }
        }
        System.out.println(cat);
        System.out.println(dog);
        if(cat==dog){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        CatDog obj=new CatDog();
        System.out.println(obj.catDog("catcat"));
    }
}
