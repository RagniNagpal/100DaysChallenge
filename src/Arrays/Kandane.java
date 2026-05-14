package Arrays;

public class Kandane {
    //Maximum Subarray Sum
    //tc O(n) scO(1)
    public static int maxSub(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            max=Math.max(max,sum);
            if(sum <0){
                sum=0;
            }
        }

        return max;
    }

    //Maximum Sum Subarray Print karo
//    public static void print(int[] arr,int start,int end){
//        int n=arr.length;
//
//    }

    //min subarray sum
    public static int minSub(int[] arr){
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            min=Math.min(min,sum);
            if(sum > 0){
                sum=0;
            }
        }

        return min;
    }

    //3. Maximum Circular Subarray Sum

    //Maximum Product Subarray
//    In product problems, negative numbers create a tricky situation because:
//    negative × negative = positive
//    So a very small negative product can become the maximum product later.
//    Also, whenever we encounter 0, the product becomes 0, so we restart the product calculation.
//    To handle all cases:
//    we calculate product from left → right and also from right → left
//    This helps us cover cases where:
//    maximum product subarray starts after a negative number or ends before a negative number
    public static int maxProduct(int[] arr){
        int n=arr.length;
        int left_product=1;
        int right_product=1;
        int max_product=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(left_product==0){
                left_product=1;
            }
            if (right_product == 0)
                right_product = 1;
            left_product *= arr[i];
            right_product *= arr[n-i-1];
            max_product = Math.max(max_product, Math.max(left_product, right_product));

        }
        return max_product;
    }


    //6. Flip 0s to 1s for Maximum 1s
    //7. Best Time to Buy and Sell Stock
    //8. Maximum Sum Rectangle in Matrix


    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSub(arr));
        System.out.println(minSub(arr));
    }
}
