package Target100Days;
import java.util.*;

public class Day46 {
    //palindrome check
    //tc O(n) sc O(1)
    public boolean isPalindrome(String s) {
        int n=s.length();
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int left=0;
        int right=s.length()-1;
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //palibdrome 2
    //tc sc o(n)
    static int isPalindrome2(String s){

        // If reverse string is equal to given string,
        // then it is palindrome.
        return s.equals(new StringBuilder(s)
                .reverse()
                .toString()) ? 1 : 0;
    }

    //reverse string
    //tc o(n) sc o(1)
    public void reverseString(char[] s) {
        int start=0;
        int end=s.length-1;
        while(start < end){
            char temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }

    }

    //reverse2
    //tc sc o(n)
    static String reverseString2(String s) {
        StringBuilder res = new StringBuilder();

        // Traverse on s in backward direction
        // and add each character to a new string
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    //rotate string
    //tc sc o(n)
    public boolean rotateString(String s, String goal) {
        String res=s+s;
        if(res.contains(goal)){
            return true;
        }
        return false;
    }

    //o(n^2) sc o(n)]
    public boolean rotate(String s,String goal){
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.equals(goal)){
                return true;
            }
            char last=s.charAt(n-1);
            s = last + s.substring(0, s.length() - 1);
        }
        return false;
    }

    //reverse words
    //tc O(n) sc O(n)
    public String reverseWords(String s) {
        String[] parts=s.trim().split("\\s+");
        int start=0;
        int end=parts.length-1;
        while(start<end){
            String temp=parts[start];
            parts[start]=parts[end];
            parts[end]=temp;
            start++;
            end--;
        }
        return String.join(" ",parts);
    }

    // anagrams
    //Time Complexity: O(m × log(m) + n × log(n))
    //sc O(n+m)
    public boolean isAnagram(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int n=arr1.length;
        int m=arr2.length;
        if(s!=t) return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    // tc o(n+m) sc O(1)
    public boolean isAnagram2(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m) return false;
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<m;i++){
            freq[t.charAt(i) - 'a']--;
        }
        for(int count : freq){
            if(count !=0){
                return false;
            }
        }
        return true;
    }

    //first non repeating
    // tc O(n) sc O(!)
    public int firstUniqChar(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(s.indexOf(c)==s.lastIndexOf(c)){
                return i;
            }
        }
        return -1;
    }

    // O(n) sc O(!)
    public int firstUniqChar2(String s) {
        int[] count = new int[26];

        // Count frequencies
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {

    }
}
