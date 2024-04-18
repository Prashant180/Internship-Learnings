package Wallet_Id;

import java.util.Random;
import java.util.Scanner;

public class WalletId {
    public String walletId(String name, String shopName, String phone,String email){
        Random random=new Random();
        int random_int=random.nextInt();
        String str=name.substring(0,2);

        String customerId=phone + '@' + str + random_int;

        Sendmail mail=new Sendmail();
        mail.sendmail(customerId,email);


        return customerId;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name:");
        String name=sc.next();
        sc.next();
        System.out.println("Enter shop name:");
        String shopName=sc.next();
        sc.next();
        System.out.println("Enter phone number:");
        String phone= sc.next();
        System.out.println("Enter email:");
        String email=sc.next();


        WalletId obj=new WalletId();
        System.out.println(obj.walletId(name,shopName,phone,email));

    }

}
