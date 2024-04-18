package codingBat;

public class Lucky13 {
    public boolean lucky13(int[] nums) {
        for (int element: nums) {
            if (element == 1 || element ==3){
                return false;
            }
        }
        return true;
    }
}
