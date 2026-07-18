package Target100Days;
import java.util.*;

public class Day59 {
    //letter comb of phone no
    //tc  \(O(4^N)\) sc O(n)
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        solve(digits, 0, "", ans);
        return ans;
    }

    public static void solve(String digits, int idx, String current, List<String> ans) {
        if (idx == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = val(digits.charAt(idx));
        for (int i = 0; i < letters.length(); i++) {
            solve(digits, idx + 1, current + letters.charAt(i), ans);
        }
    }

    public static String val(char ch) {
        if (ch == '1') return " ";
        if (ch == '2') return "abc";
        if (ch == '3') return "def";
        if (ch == '4') return "ghi";
        if (ch == '5') return "jkl";
        if (ch == '6') return "mno";
        if (ch == '7') return "pqrs";
        if (ch == '8') return "tuv";
        if (ch == '9') return "wxyz";
        return "";
    }
    public static void main(String[] args) {
        
    }
}
