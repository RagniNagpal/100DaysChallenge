package Target100Days;
import java.util.*;

public class Day33 {
    // Majority Element II
    //Time Complexity: O(N^2)
    //Space Complexity: O(1)
    public List<Integer> majorityElement(int[] nums) {
            int n = nums.length;
            List<Integer> list=new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < n; i++){
            int count=1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i+1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }
                    if (count > n / 3) {
                        list.add(nums[i]);

                }
            }
            return list;
        }

        //tc sc O(n)
    public List<Integer> majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n=nums.length;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() > n/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    //Remove Nth Node From End of List
    //Time: O(N) (ek pass length ke liye + ek pass delete ke liye)
    //Space: O(1)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = 0;
            ListNode temp = head;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            if (len == n) {
                return head.next;
            }
            int pos = len - n;
            temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }

    //Maximum Sum Combination
    //Time Complexity: O(n * m + nmlog(nm)) ,We compute all n * m pairwise sums. Sorting takes O(nm log nm). Extracting top k is O(k).
    //Space Complexity:O(n * m) ,
    public List<Integer> maxCombinations(int[] nums1, int[] nums2, int k) {
        List<Integer> allSums = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                allSums.add(nums1[i] + nums2[j]);
            }
        }
        // Sort all sums in descending order
        allSums.sort(Collections.reverseOrder());
        return allSums.subList(0, k);
    }

    //Median of row wise sorted matrix
    //Time Complexity: O(M*N*(log(M*N))), sorting the linear array takes time complexity of O(M*N(logM*N)).
    //Space Complexity: O(M*N),
    public int findMedian(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();
        for (int[] row : matrix) {
            for (int val : row) {
                elements.add(val);
            }
        }
        Collections.sort(elements);
        int n = elements.size();
        return elements.get(n / 2);
    }
    //Reverse words in string
    // tc sc O(n)
        public String reverseWords(String s) {

            String[] words = s.split("\\.");

            StringBuilder ans = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {

                if (!words[i].isEmpty()) {

                    if (ans.length() > 0) {
                        ans.append(".");
                    }

                    ans.append(words[i]);
                }
            }

            return ans.toString();
        }

        //Minimum Insertions to Make a String Palindrome
    // tc sc O(n^2)
        public static int lcs(String s) {

            String rev = new StringBuilder(s).reverse().toString();

            int n = s.length();

            int[][] dp = new int[n + 1][n + 1];

            for(int i = 1; i <= n; i++) {

                for(int j = 1; j <= n; j++) {

                    if(s.charAt(i - 1) == rev.charAt(j - 1)) {

                        dp[i][j] = 1 + dp[i - 1][j - 1];

                    } else {

                        dp[i][j] = Math.max(dp[i - 1][j],
                                dp[i][j - 1]);
                    }
                }
            }

            return dp[n][n];
        }

    public int minInsertions(String s) {

        int lps = lcs(s);

        return s.length() - lps;
    }

    //Longest comon prefix
    //TC = O(N log N × M)
    //SC = O(1)
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2=strs[strs.length-1];
        int idx=0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx)==s2.charAt(idx)){
                idx++;
            }else{
                break;
            }
        }
        return s1.substring(0, idx);
    }

    //TC O(N × M)
    //SC O(1)
    public String longestCommonPrefix2(String[] strs) {

        for(int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++) {

                if(i == strs[j].length() ||
                        strs[j].charAt(i) != ch) {

                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    // Roman to Integer
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    class Solution {
        public int romanToInt(String s) {
            int sum=0;
            int n=s.length();
            for(int i=0;i<n;i++){
                int current=value(s.charAt(i));
                if(i+1 < n && current < value(s.charAt(i+1))){
                    sum -= current;
                }else{
                    sum += current;
                }
            }
            return sum;
        }
        private int value(char c){
            if(c=='I') return 1;
            if(c=='V') return 5;
            if(c=='X') return 10;
            if(c=='L') return 50;
            if(c=='C') return 100;
            if(c=='D') return 500;
            if(c=='M') return 1000;

            return 0;}
    }

    //longest palindrome substring
    //Time Complexity  : O(n³)
    //Space Complexity : O(n)
    public String longestPalindrome(String s) {
        int n=s.length();
        String longest="";
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String sub=s.substring(i,j);
                if(palindrome(sub) && sub.length() > longest.length()){
                    longest=sub;
                }
            }
        }
        return longest;
    }
    public boolean palindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;}
            start ++;
            end--;

        }
        return true;
    }
    public static void main(String[] args) {

    }
}
