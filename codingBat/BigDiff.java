package codingBat;

public class BigDiff {
    public int bigDiff(int[] nums) {
        int diff=0;
        int largeDiff=0;
        for (int i=0;i< nums.length-1;i++){
                diff = Math.abs(nums[i] - nums[i+1]);
                largeDiff = Math.max(diff, largeDiff);
        }
        return largeDiff;
    }
    public static void main(String[] args){
        BigDiff obj=new BigDiff();
        int[] arr= new int[]{7,2,10,9};
        System.out.println(obj.bigDiff(arr));
    }
}
