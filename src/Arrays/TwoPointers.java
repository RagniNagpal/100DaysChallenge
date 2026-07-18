package Arrays;

public class TwoPointers {
//    🔥 TWO POINTER MASTER SET
 //Level 1 — Basic Two Pointer (opposite ends)

//Reverse an array (tu already kar chuki hai)
    //tc O(n) sc=o(1)
    public static void rev(int[] arr){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start < end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;

        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }

//Check if array is palindrome
    // tc O(n) sc=0(1)
    public static boolean palin(int[] arr){
        int n=arr.length;
        int start =0;
        int end=n-1;
        while(start <= end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

//Two Sum (sorted array version)
// tc O(n) sc=0(n)
    public static int[] twoSum(int[] arr,int target){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start <= end){
            int sum=arr[start]+arr[end];
            if(sum==target){
                return new int[]{start,end};
            }
            else if(sum < target){
               start++;
            }else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }

    //Remove duplicates from sorted array
    // tc O(n) sc=0(1)
    public static int remDup(int[] arr){
        int n=arr.length;
        int i=0;
        int j=1;
        while(j<n){
            if(arr[i]!=arr[j]){
              i++;
                arr[i] = arr[j];
            }else{
                j++;
            }
        }
        return i+1;
    }

//Move zeroes to end (in-place)
// tc O(n) sc=0(1)
    public static void move(int[] arr){
        int n=arr.length;
        int start=0;
        for(int end=0;end<n;end++){
            if(arr[end]!=0){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
            }
        }
    }

//🟡 Level 2 — Expand Thinking

//Container With Most Water
//public int maxArea(int[] height) {
//    int n=height.length;
//
//}
//Squares of sorted array
//(-ve +ve mix → sorted output)
//Merge two sorted arrays
//3 Sum (triplet sum = 0)

//Remove element (in-place)
public int removeElement(int[] nums, int val) {
    int n=nums.length;
    int i=0;
    for(int j=0;j<n;j++){
        if(nums[j]!=val){
            nums[i]=nums[j];
            i++;
        }

    }
    return i;
}


//🔴 Level 4 — Interview Heavy

//Trapping rain water
// 4 Sum
//Partition array (even left, odd right)


    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,5};
        rev(arr);
        System.out.println(remDup(arr));
    }
}
