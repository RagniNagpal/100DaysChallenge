package ReRevise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    // Time Complexity: O(n * k log k)
    // Space Complexity: O(n * k)
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagram solution = new GroupAnagram();
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("Grouped anagrams:");
        List<List<String>> result = solution.groupAnagrams(words);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
