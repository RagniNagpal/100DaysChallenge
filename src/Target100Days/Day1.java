package Target100Days;
import java.util.*;

public class Day1 {
    //Subsequence with Bit Manipulation
    public static void subsequences(String s) {
        int n = s.length();
        int total = 1 << n;
        for(int num = 0; num < total; num++) {
            String ans = "";
            for(int i = 0; i < n; i++) {
                if((num & (1 << i)) != 0) {
                    ans += s.charAt(i);
                }
            }
            System.out.println(ans);
        }
    }

    //Power Set bit manipulation
    public static void powerSet(int[] nums) {
        int n = nums.length;
        int total = 1 << n;
        for(int num = 0; num < total; num++) {
            List<Integer> subset = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if((num & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            System.out.println(subset);
        }
    }
    public static void main(String[] args) {
        System.out.println("---String Subsequences---");
        subsequences("abc");
        System.out.println("---Integer Power Set---");
        powerSet(new int[]{1, 2, 3});
    }
}
