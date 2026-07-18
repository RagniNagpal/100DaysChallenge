package Target100Days;

public class Day48 {
    //equals point in braclets
    //tc O(n^2) sc O(1)
    public int findIndex(String s) {
        int n = s.length();

        for (int i = 0; i <= n; i++) {
            int openCnt = 0, closeCnt = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '(')
                    openCnt++;
            }
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == ')')
                    closeCnt++;
            }

            if (openCnt == closeCnt)
                return i;
        }

        return -1;
    }

    //inversion of array
    //
    public static int Inv(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Inv(arr));
    }
}
