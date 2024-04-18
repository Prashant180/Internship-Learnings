package codingBat;

public class Sum13 {
    public int sum13(int[] nums) {
        int total=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==13){
                i++;
            }else{
                total=total+nums[i];
            }
        }
        return total;
    }
    public static void main(String[] args){
        Sum13 obj=new Sum13();
        int[] arr=new int[]{13, 1, 2, 13, 2, 1, 13};
        System.out.println(obj.sum13(arr));
    }
}
