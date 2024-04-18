package codingBat;

public class Sum67 {
    public int sum67(int[] nums) {
        int total=0;
        boolean stop=false;
        for (int i=0;i< nums.length;i++){
            if(nums[i]==6){
                stop=true;
            }
            if (!stop){
                total+=nums[i];
            }
            if(nums[i]==7){
                stop=false;
            }
        }
        return total;
    }
    public static void main(String[] args){
        int[] arr=new int[]{1, 1, 6, 7, 2};
        Sum67 obj=new Sum67();
        System.out.println(obj.sum67(arr));

    }
}
