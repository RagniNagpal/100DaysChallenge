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

        // Create a list to store all elements
        List<Integer> elements = new ArrayList<>();

        // Traverse each row of the matrix
        for (int[] row : matrix) {

            // Traverse each element in the current row
            for (int val : row) {

                // Add element to list
                elements.add(val);
            }
        }

        // Sort the list of elements
        Collections.sort(elements);

        // Return the middle element (median)
        int n = elements.size();
        return elements.get(n / 2);
    }
    public static void main(String[] args) {

    }
}
