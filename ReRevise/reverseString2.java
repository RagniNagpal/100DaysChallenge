package ReRevise;

public class reverseString2 {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean reverse = true;

        for (int i = 0; i < n; i += k) {
            if (reverse) {
                int left = i;
                int right = Math.min(i + k - 1, n - 1);
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }
            reverse = !reverse;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        reverseString2 solution = new reverseString2();
        String s = "abcdefg";
        int k = 2;
        System.out.println("Reversed string: " + solution.reverseStr(s, k));
    }
}
