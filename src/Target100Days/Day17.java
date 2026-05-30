package Target100Days;

public class Day17 {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            int secondaryCol = n - i - 1;
            if (i != secondaryCol) {
                sum += mat[i][secondaryCol];
            }
        }

        return sum;
    }
}
