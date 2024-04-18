package codingBat;

public class BillSplit {
    public int billSplit(int bill,int a,int b,int c){
        int split=bill/3;
        int aGet=0;
        int aPay=0;
        int bGet=0;
        int bPay=0;
        int cGet=0;
        int cPay=0;
        int aRemaining=0;
        int bRemaining=0;
        int cRemaining=0;
        if (split>a){
            aPay=split-a;
        } else {
            aGet=a-split;
        }
        if (split>b){
            bPay=split-b;
        } else {
            bGet=b-split;
        }
        if (split>c){
            cPay=split-c;
        } else {
            cGet=c-split;
        }

        if(aPay>0){
          if(aPay>=bGet){
              System.out.println("a pays to b "+bGet);
              aRemaining =aPay - bGet;
              if (cGet>0 && aRemaining>0){
                  System.out.println("a pays to c "+aRemaining);
              }
          }else {
              System.out.println("a pays to b "+ aPay);
          }
        }
        if(bPay>0){
            if(bPay>=aGet){
                System.out.println("b pays to a "+aGet);
                bRemaining =bPay - aGet;
                if (cGet>0 && bRemaining>0){
                    System.out.println("b pays to c "+bRemaining);
                }
            }else {
                System.out.println("b pays to a"+ bPay);
            }
        }
//        if(cPay>0){
//            if(cPay>=aGet){
//                System.out.println("c pays to a "+aGet);
//                cRemaining =cPay - aGet;
//                if (bGet>0 && cRemaining>0){
//                    System.out.println("c pays to b "+cRemaining);
//                }
//            }else if(cPay<aGet){
//                System.out.println("c pays to a"+ cPay);
//            }
//        }
         if (cPay>0){
             if(aGet>0 && aGet<=cPay){
                 System.out.println("c pays to a "+(cPay-aGet));
                 cRemaining=cPay-aGet;
                 if (bGet>0 && cRemaining>0){
                    System.out.println("c pays to b "+cRemaining);
                }
             }else if (aGet>0){
                 System.out.println("c pays to a "+ cPay);
             } else if (bGet>0){
                 System.out.println("c pays to b "+ cPay);
             }
         }
        return 0;
    }
//    public int perPerson(int split,int sum,String name){
//        if (split > sum) {
//            System.out.println(name + "needs to pay" +(split-sum));
//        }else if(sum>split){
//            System.out.println(name+ "gets "+ (sum-split));
//        }
//        return 0;
//    }

    public static void main(String[] args){
        BillSplit obj=new BillSplit();
        System.out.println(obj.billSplit(1500,200,800,500));
    }
}
