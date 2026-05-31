package Target100Days;
import java.util.*;

public class Day18 {
    //Arrays is equal or not
    public static boolean equal(int[] arr1, int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    //longest consecutive subsequence
    public static int LCS(int[] arr){
        int n=arr.length;
        Arrays.sort(arr);
        int count=1;
        int max=1;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]) continue;
            if(arr[i]==arr[i-1]+1){
                count++;
            }else{
                count=1;
            }
            max=Math.max(max,count);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr1={1,3,2};
        int[] arr2={1,2,3};
        int[] arr={1,2,4,6,7,5,4,4,0};
        System.out.println("Are arrays equal? " + equal(arr1, arr2));
        System.out.println(LCS(arr));
    }
}
