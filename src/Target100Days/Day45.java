package Target100Days;

public class Day45 {
    //Substring of palindromic string
    public static boolean ispalin(String s){
        int n=s.length();
        int left=0;
        int right=n-1;
        while(left < right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void sub(String str){
        int n=str.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                 String s=str.substring(i,j);
                if(ispalin(s)==true){
                    System.out.println(s);
                }
            }
        }
    }
    public static void main(String[] args) {
        String str="nitin";
        sub(str);
    }
}
