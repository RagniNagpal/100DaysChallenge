package Target100Days;
import java.util.*;

public class Day50 {
    //sort colours
    class Solution {
        public void sortColors(int[] nums) {
            int n=nums.length;
            for(int i=0;i<n-1;i++){
                for(int j=0;j<n-i-1;j++){
                    if(nums[j] > nums[j+1]){
                        int temp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                    }
                }
            }
        }
    }

    //3 sum
        public List<List<Integer>> threeSum(int[] nums) {
            int n=nums.length;
            List<List<Integer>> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    for(int k=j+1;k<n;k++){
                        if(nums[i]+nums[j]+nums[k]==0){
                            List<Integer> res = new ArrayList<>();
                            res.add(nums[i]);
                            res.add(nums[j]);
                            res.add(nums[k]);
                            Collections.sort(res);
                            if (!list.contains(res)) {
                                list.add(res);
                            }
                        }
                    }
                }
            }
            return list;

    }
    public static void main(String[] args) {

    }
}
