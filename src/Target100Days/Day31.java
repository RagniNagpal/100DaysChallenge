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
    public static void main(String[] args) {

    }
}
