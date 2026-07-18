package Target100Days;

import java.util.*;

// Greedy Problems
public class Day3 {

    // Assign Cookies
    static int assignCookie(int[] greed, int[] cookie) {

        int i = 0;
        int j = 0;

        Arrays.sort(greed);
        Arrays.sort(cookie);

        while (i < greed.length && j < cookie.length) {

            // cookie satisfies child
            if (cookie[j] >= greed[i]) {
                i++;
            }

            j++;
        }

        return i;
    }

    // Minimum Partition
    static List<Integer> minPartition(int N) {

        int[] notes = {
                2000, 500, 200, 100,
                50, 20, 10, 5, 2, 1
        };

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < notes.length; i++) {

            while (N >= notes[i]) {

                list.add(notes[i]);

                N = N - notes[i];
            }
        }

        return list;
    }

    public static void main(String[] args) {

        // Assign Cookies Example
        int[] greed = {1, 2, 3};
        int[] cookie = {1, 1};

        int ans = assignCookie(greed, cookie);

        System.out.println("Satisfied Children = " + ans);

        // Minimum Partition Example
        int N = 143;

        List<Integer> result = minPartition(N);

        System.out.println("Minimum Partition:");

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}