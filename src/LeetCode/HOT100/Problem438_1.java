package LeetCode.HOT100;

import java.util.ArrayList;
import java.util.List;

public class Problem438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int n = s.length();
        int m = p.length();

        int[] count = new int[26];
        for (int i = 0; i < m; i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }
        if (check(count) == 1) {
            result.add(0);
        }
        for (int i = 0; i < n - m; i++) {
            count[s.charAt(i + m) - 'a']--;
            count[s.charAt(i - m) - 'a']++;
            if (check(count) == 1) {
                result.add(i - m + 1);
            }
        }
        return result;
    }

    private int check(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return 0;
        }
        return 1;
    }


}
