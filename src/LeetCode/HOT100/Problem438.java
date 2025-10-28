package LeetCode.HOT100;

import java.util.*;

public class Problem438 {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     */
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        int left = 0;
        int right = 0;

        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String p1 = new String(chars);
        List<Integer> list = new ArrayList<>();
        while (right < n) {
            int count = 0;
            Character c = s.charAt(right);

            if (p.contains(String.valueOf(c))) {
                left = right;
                while (count <= m && right < n && p.contains(String.valueOf(s.charAt(right)))) {
                    count++;
                    right++;
                }
            }
            if (count == m) {
                String substring = s.substring(left, right);
                char[] chars1 = substring.toCharArray();
                Arrays.sort(chars1);
                String substring1 = new String(chars1);
                if (substring1.equals(p1)) {
                    list.add(left);
                }
            }
            left++;
            right = left;

        }
        return list;
    }
}

