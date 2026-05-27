package Target100Days;
import java.util.*;

public class Day14 {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int x : nums2) {
            if(set.contains(x)){
                result.add(x);
            }
        }
        int[] ans = new int[result.size()];
        int i = 0;

        for (int x : result) {
            ans[i++] = x;
        }
        return ans;
    }

     public static boolean containsDuplicate(int[] nums) {
            int n=nums.length;
            Set<Integer> set=new HashSet<>();
            for(int i:nums){
                set.add(i);
            }
            if(set.size() < n) {
                return true;
            }
            return false;
        }
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,8};
        int[] arr1 = {4,4,3,9};

        // numJewelsInStones
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));

        // intersection
        System.out.println(Arrays.toString(intersection(arr, arr1)));

        // containsDuplicate
        System.out.println(containsDuplicate(arr));
    }
}
