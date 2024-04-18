package codingBat;

import java.util.Scanner;

public class UserInput {
    public boolean conditions(int num,String str){

        if(num%2!=0 || num<10 || num>9999){
            return false;
        }

        while (num>1){
            num= num/10;
        }
        if(num%2==0){
            return false;
        }

        if(str.length()>5 && str.length()<10){
            if(str.charAt(0) == 'a' || str.charAt(0)== 'b' || str.charAt(0)== 's' || str.charAt(0)== 'p'){


                if(str.contains("x") || str.contains("y")||str.contains("z") ){
                    return false;
                }
            } else {
                return true;
            }
        } else return false;

        return true;
    }
    public int  choice(){

        Scanner sc=new Scanner(System.in);
        System.out.println("Select the option from below:");
        System.out.println(" 1 for CREATE");
        System.out.println(" 2 for READ");
        System.out.println(" 3 for UPDATE");
        System.out.println(" 4 for DELETE");
        int option=sc.nextInt();
        System.out.println("Enter number of times ");
        int num=sc.nextInt();

        switch (option){
            case  1:
                for (int i=0;i<num;i++){
                    System.out.println("CREATE");
                }
                break;
            case 2:
                for (int i=0;i<num;i++){
                    System.out.println("READ");
                }
                break;
            case 3:
                for (int i=0;i<num;i++){
                    System.out.println("UPDATE");
                }
                break;
            case 4:
                for (int i=0;i<num;i++){
                    System.out.println("DELETE");
                }
                break;
            default:
                System.out.println("TRY AGAIN");
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number ");
        int num=sc.nextInt();
        System.out.println("Enter a string ");
        String str=sc.next();

        UserInput obj=new UserInput();
        System.out.println(obj.conditions(num,str));
        if(obj.conditions(num,str)){
            System.out.println("Eureka");
        }else {
            System.out.println("twat");
        }
        obj.choice();

    }
}
