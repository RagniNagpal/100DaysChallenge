package Target100Days;
import java.util.*;
import java.math.*;

public class Day47 {
    //tc sc O(n+m)
    public String addStrings(String num1, String num2) {
        BigInteger a=new BigInteger(num1);
        BigInteger b=new BigInteger(num2);
        String res = a.add(b).toString();
        return res;
    }

    //Isomorphic strings
    //tc O(n^2) scO(1)
    public boolean isIsomorphic(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m!=n) return false;
        for(int i=0;i<m;i++){
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //encrypt the string
    //tc sc O(n)
    String encryptString(String s) {

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = s.length() - 1; i >= 0; i--) {

            while (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
                i--;
            }

            sb.append(Integer.toHexString(count));

            sb.append(s.charAt(i));

            count = 1;
        }

        return sb.toString();
    }

    //panagram check
    //TC = O(n)
    //SC = O(1)
    public boolean checkIfPangram(String sentence) {
        String alp = "abcdefghijklmnopqrstuvwxyz";
        int n=sentence.length();
        for(char c:alp.toCharArray()){
            if(!sentence.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
    }

    //palindrome sentence
    //TC = O(n)
    //SC = O(1)
    public boolean isPalinSent(String s) {

        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
