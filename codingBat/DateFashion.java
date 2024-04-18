package codingBat;

public class DateFashion {
    public int dateFashion(int you, int date) {
        if((you>=8) || (date>=8)){
            if((you<=2) || (date<=2)){
                return 0;
            }
            return 2;
        } else if ((you<=2) || (date<=2)){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args){
        DateFashion obj=new DateFashion();
        System.out.println(obj.dateFashion(5,2));
    }
}
