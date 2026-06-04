package Target100Days;
import java.util.*;

public class Day22 {
//    . Union of Two Arrays
        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {3, 4, 5, 6};

            HashSet<Integer> set = new HashSet<>();

            for(int x : arr1) {
                set.add(x);
            }

            for(int x : arr2) {
                set.add(x);
            }

            System.out.println("Union Size = " + set.size());
            System.out.println(set);

    }
}
