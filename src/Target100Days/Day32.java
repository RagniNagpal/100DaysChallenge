package Target100Days;
import java.util.*;

public class Day32 {
    //Rotate Image by 90 degree
    //tc sc O(n^2)
    public int[][] rotateClockwise(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    //tc O(n^2) sc O(1)
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            int left=0;
            int right=n-1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // kth element of 2 array
    public static int kth(int[] arr1 , int[] arr2,int k){
        int n=arr1.length;
        int m=arr2.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:arr1){
            list.add(i);
        }
        for(int j:arr2){
            list.add(j);
        }
        Collections.sort(list);
        return list.get(k-1);
    }

    // Median of Two Sorted Arrays
    //Time: O(log(min(n,m)))
    //Space: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i:nums1){
            list.add(i);
        }
        for(int j:nums2){
            list.add(j);
        }
        Collections.sort(list);
        int size=list.size();
        if(size%2==1){
            return list.get(size/2);
        }else{
            return (list.get(size / 2) + list.get((size / 2) - 1)) / 2.0;
        }
    }

    //Single Element in a Sorted Array
    //Tc o(n) sc O(1)
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            res=res^nums[i];
        }
        return res;
    }

    //Time: O(log n)
    //Space: O(1)
    class Solution {
        public int singleNonDuplicate(int[] nums) {

            int low = 0;
            int high = nums.length - 1;

            // Jab tak search space mein ek se zyada element hain
            while (low < high) {

                int mid = low + (high - low) / 2;

                // Mid ko even index par le aao
                // Kyunki hum pair ko (even, odd) form mein check karna chahte hain
                //
                // Example:
                // index : 0 1 2 3 4 5
                // value : 1 1 2 2 3 3
                //          ↑   ↑   ↑
                //        even even even
                //
                // Agar mid = 3 aaya to use 2 bana denge
                if (mid % 2 == 1) {
                    mid--;
                }

                // Ab hum pair check kar rahe hain:
                // nums[mid] aur nums[mid+1]

                if (nums[mid] == nums[mid + 1]) {

                    // Pair sahi mila
                    //
                    // Example:
                    // [1,1,2,2,3,4,4]
                    //      ↑ ↑
                    //
                    // Matlab single element abhi tak nahi mila
                    // Single element right side mein hoga
                    //
                    // Isliye left part ko hata do
                    low = mid + 2;

                } else {

                    // Pair toot gaya
                    //
                    // Example:
                    // [1,1,2,3,3,4,4]
                    //      ↑ ↑
                    //      2 3  (equal nahi)
                    //
                    // Matlab single element mid par ya left side mein hai
                    //
                    // Right part ko hata do
                    high = mid;
                }
            }

            // Jab low == high ho jayega
            // wahi single element ka index hai
            return nums[low];
        }
    }

    //Count the number of subarrays with given xor K
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    //tle
    public long subarrayXor(int arr[], int k) {
            // code here
            int n=arr.length;
            int count =0;
            for(int i=0;i<n;i++){
                int xor =0;
                for(int j=i;j<n;j++){
                    xor ^= arr[j];
                    if(xor == k){
                        count++;
                    }
                }
            }
            return count;
        }

        //optimal Time Complexity: O(N)
        //Space Complexity: O(N)
        public long subarrayXor2(int arr[], int k) {
            // code here
            Map<Integer, Integer> freq = new HashMap<>();
            freq.put(0, 1);
            int prefixXor = 0;
            int count = 0;
            for (int num : arr) {
                prefixXor ^= num;
                int target = prefixXor ^ k;
                if (freq.containsKey(target)) {
                    count += freq.get(target);
                }
                freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
            }
            return count;
        }
    public static void main(String[] args) {
        int[] arr1={2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kth(arr1,arr2,k));
    }
}
