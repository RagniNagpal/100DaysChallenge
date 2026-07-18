package Target100Days;

import java.sql.SQLOutput;

public class Day44 {
    // string manupulation url parsing
    public static String solve(String str){
        int n=str.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='/'){
                sb.append(" ");
            }else if(str.charAt(i)=='.'){
                sb.append(" ");
            }
            else if (str.charAt(i) == '?') {
                sb.append(" ");
            }else if(str.charAt(i)=='&'){
                sb.append("]");
            }else if(str.charAt(i)=='='){
                if(i>0 && str.charAt(i-1)=='e'){
                    sb.append("[");
                }else{
                    sb.append("[:");
                }
            }else{
                sb.append(str.charAt(i));
            }
        }
        sb.append(":]");
        return sb.toString();
    }

    //network ip
    public static String network(String st){
        int n=st.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(st.contains(".")){
                return "IPv4";
            }
            else if(st.contains(":")){
                return "IPv6";
            }
            else{
                return "Neither";
            }
        }
        return "-1";
    }

    //pattern
    //*   *   *
    // * * * *
    //  *   *
//    public static void print(int n) {
//
//        for (int i = 0; i < 3; i++) {
//
//            for (int j = 0; j < n; j++) {
//
//                if (i == 0) {
//                    if (j % 2 == 0)
//                        System.out.print("*");
//                    else
//                        System.out.print(" ");
//                }
//
//                else if (i == 1) {
//                    System.out.print("*");
//                }
//
//                else {
//                    if (j == 0 || j == n - 1)
//                        System.out.print("*");
//                    else
//                        System.out.print(" ");
//                }
//            }
//
//            System.out.println();
//        }
//    }

    // prefix string vala
    //pattern
    //ek agar ek string hack a aage 1*1 bnaega hcka then c last kei 2* 4 kuch ese tha

    //
    public static void main(String[] args) {
        String str = "https://abc.com/user/profile?id=101&name=Riya";
        String st="0.0.0.0";
        System.out.println(solve(str));
//        System.out.println(network(st));
//        print(3);
    }
}
