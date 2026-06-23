package Target100Days;

public class Day41 {
    //Largest elemnet
    public static int largestel(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max <arr[i]){
               max=arr[i];
            }
        }
        return max;
    }
    //without extra array reverse
    public static void rev(int[] arr){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start < end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start ++;
            end--;
        }
    }

    //sum of array
    public static int sum(int[] arr){
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        return sum;
    }

    //second largest
    public static int secLar(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max <arr[i]){
                max=arr[i];
            }
        }
        int sec=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>sec && arr[i]!=max){
                sec=arr[i];
            }
        }
        return sec;
    }

    //reverse no
    public static int revNo(int a){
        int rev=0;
        int rem=0;
        while(a !=0){
            rem=a%10;
            rev=rev*10+rem;
            a=a/10;
        }
        return rev;
    }
    //palindrome
    public static boolean palin(int num){
        int n=num;
        int rev=0;
        int rem=0;
        while(num !=0){
            rem=num%10;
            rev=rev*10+rem;
            num=num/10;
        }
        return rev == n;
    }

    //count digits
    public static int cnt(int num){
        if(num == 0){
            return 1;
        }
        int count=0;
        while(num >0){
            num=num/10;
            count++;
        }
        return count;
    }
    //Prime Number
    public static boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    //Fibonacci
    public static void fib(int num){
        int a = 0;
        int b = 1;

        for(int i = 0; i < num; i++){
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
    }
    //Factorial
    public static int fact(int num){
        int fact=1;
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int[] arr={1,2,2,3,7};
        int a=223344;
        int num=131;
        System.out.println(largestel(arr));
        rev(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(sum(arr));
        System.out.println(secLar(arr));
        System.out.println(revNo(a));
        System.out.println(palin(num));
        System.out.println(cnt(num));
        System.out.println(isPrime(num));
        fib(5);
        System.out.println();
        System.out.println(fact(5));
    }
}
