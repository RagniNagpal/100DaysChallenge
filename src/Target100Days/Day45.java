package Target100Days;
import java.util.*;

public class Day45 {
    //Substring of palindromic string
    public static boolean ispalin(String s){
        int n=s.length();
        int left=0;
        int right=n-1;
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void sub(String str){
        int n=str.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                 String s=str.substring(i,j);
                if(ispalin(s)==true){
                    System.out.println(s);
                }
            }
        }
    }

    //string compression with string builder
    //✅ Time: O(n)
    //✅ Space: O(n)
    public static String compress(String str2){
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<str2.length();i++){
            while(i<str2.length()-1 && (str2.charAt(i)==str2.charAt(i+1))){
                count++;
                i++;
            }
            sb.append(str2.charAt(i));
            if(count >1){
                sb.append(count);
            }
            count=1;
        }
        return sb.toString();
    }

    //string comp2
//    ✅ Time: O(n^2)
//✅ Space: O(n)
    public static String compress2(String str2){
        String res="";
        int count=1;
        for(int i=0;i<str2.length();i++){
            while(i<str2.length()-1 && str2.charAt(i)==str2.charAt(i+1)){
                count++;
                i++;
            }
            res += str2.charAt(i);
            if(count > 1){
                res+=count;
            }
            count=1;
        }
        return res;
    }

    //remove prime no from arraylist
    //TC: O(n²) (or more precisely O(n² + n√m))
    //SC: O(1)
    public static boolean isPrime(int n) {

        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    public static void removePrime(ArrayList<Integer> list) {

        for (int i = list.size() - 1; i >= 0; i--) {
            if (isPrime(list.get(i))) {
                list.remove(i);
            }
        }
    }

    //toggle case
    public static String toggle(String s){

    }
    //
    //
    public static void main(String[] args) {
        String str="nitin";
        sub(str);
        String str2 = "aaabbccccdd";
        System.out.println(compress(str2));
        System.out.println(compress2(str2));
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(7);
        list.add(8);
        list.add(13);
        list.add(20);
        list.add(17);

        removePrime(list);

        System.out.println(list);
    }
}
