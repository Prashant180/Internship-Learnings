package codingBat;

import java.util.Arrays;

public class CountEven {
    public int countEvens(int[] nums) {
        int count=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]%2==0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        CountEven obj=new CountEven();
        int[] arr= new int[]{2,1,2,3,4};
        System.out.println(obj.countEvens(arr));
    }
}
