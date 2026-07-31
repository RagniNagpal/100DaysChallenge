package ReRevise

public class Main{
  public static void main(String[] args){
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
  }
}