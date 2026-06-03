package Target100Days;
import java.util.*;

public class Day21 {

    public static ArrayList<Integer> countDistinct(int[] arr, int k) {

        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i <= n - k; i++) {

            HashSet<Integer> st = new HashSet<>();

            for(int j = i; j < i + k; j++) {
                st.add(arr[j]);
            }

            res.add(st.size());
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        System.out.println(countDistinct(arr, k));
    }
}