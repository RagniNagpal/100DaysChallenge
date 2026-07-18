package Target100Days;
import java.util.*;

public class Day60 {
    //set matrix 0
    //tc  O(m * n * (m + n)), sc O(1)
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    for(int col=0;col<n;col++){
                        if (matrix[i][col] != 0)
                            matrix[i][col] = -1;
                    }
                    for(int row=0;row<m;row++){
                        if (matrix[row][j] != 0)
                            matrix[row][j] = -1;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
    }

    //tc O(m × n) sc O(n+m)
    public static void setZeros(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[] row=new boolean[m];
        boolean[] col=new boolean[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(row[i] || col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    //pascal triangle element find
    //tc O(min(c,r−c)) sc O(1)
    public long findPascalElement(int r, int c) {
        int n = r - 1;
        int k = c - 1;

        long result = 1;

        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    // get nth node of pascal triangle
    // tc sc O(N),
    public List<Long> getNthRow(int N) {
        List<Long> row = new ArrayList<>();
        long val = 1;
        row.add(val);
        // C(n, k) = C(n, k-1) * (n-k) / k
        for (int k = 1; k < N; k++) {
            val = val * (N - k) / k;
            row.add(val);
        }

        return row;
    }

    //generate
    //tc sc O(N^2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>(Collections.nCopies(i+1,1));
            for(int j=1;j<i;j++){
                row.set(j,triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {

    }
}
