package Target100Days;
import java.util.*;

public class Day31 {
    // TC = O(n × 2ⁿ), SC = O(n) (excluding output array).
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,new ArrayList<>(),nums,list);
        return list;
    }
    public void solve(int idx,List<Integer> curr,int[] nums,List<List<Integer>> list){
        list.add(new ArrayList<>(curr));

        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            solve(i+1,curr,nums,list);
            curr.remove(curr.size()-1);
        }
    }

    // Sort a astack
    //TC = O(n²)
    //SC = O(n)
    public void sortStack(Stack<Integer> st) {

        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {

            int curr = st.pop();

            while (!temp.isEmpty() && temp.peek() > curr) {
                st.push(temp.pop());
            }

            temp.push(curr);
        }

        st.clear();

        while (!temp.isEmpty()) {
            st.push(temp.remove(0));
        }
    }

    //
    // while (!temp.isEmpty()) {
    //            st.push(temp.pop());
    //        }
    //then [1,2,3]

    //balanced parenthesis
    //tc sc O(n)
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='{' || c=='[' || c=='('){
                st.add(c);
            }else{
                if(st.isEmpty()) return false;
                char top=st.pop();
                if(c=='}' && top!='{') return false;
                if(c==']' && top!='[') return false;
                if(c==')' && top!='(') return false;
            }
        }
        return st.isEmpty();
    }

    //Longest consecutive sequence
    // TC = O(n log n)
    //SC = O(1)
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int max=1;
        int count=1;
        if (n == 0) return 0;
        Arrays.sort(nums);
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]) continue;
            if(nums[i]-nums[i-1]==1){
                count++;
            }else{
                count=1;
            }
            max=Math.max(max,count);
        }
        return max;
    }

    //tc sc O(n)
    public int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {

                int curr = num;
                int count = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    //4sum
    //Time: O(n⁴)
    //Space: O(k)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i]
                                + nums[j]
                                + nums[k]
                                + nums[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(
                                    nums[i],
                                    nums[j],
                                    nums[k],
                                    nums[l]
                            );
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //TC = O(n³)
    //SC = O(1) (excluding output)
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1, right=n-1;
                while(left < right){
                    long sum=(long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[left]==nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;

                        left ++;
                        right --;
                    }
                    else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    //Pow(x,n)
    //TC = O(log n)
    //SC = O(1)
    public double myPow(double x, int n) {
            return Math.pow(x, n);
        }

        //O(n)
        //O(1)
        public double myPow2(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1.0;
            for (long i = 0; i < N; i++) {
                ans *= x;
            }
            return ans;
        }


    public static void main(String[] args) {

    }
}
