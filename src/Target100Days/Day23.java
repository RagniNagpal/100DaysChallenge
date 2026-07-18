package Target100Days;
import java.util.*;

public class Day23 {
    //find the duplicate no
    //Time Complexity: O(N log N), Space Complexity: O(1)
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    // Approach 2: HashSet (Collection)
//    Tc O(n)  sc O(n)
    public int Duplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,23};
        Day23 obj = new Day23();

        // Testing Approach 1
        System.out.println("Duplicate using Sorting: " + obj.findDuplicate(arr.clone()));

        // Testing Approach 2
        System.out.println("Duplicate using HashSet: " + obj.Duplicate(arr));
    }
}
