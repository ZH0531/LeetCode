package LeetCode.HOT100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3_1 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) return s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        //"abcabcbb"："a" → "ab" → "abc" → "bca" → "cab" → "abc" → "cb" → "b"，最大长度为 3
        while (right < s.length()) {
            char c = s.charAt(right); //获取当前字符
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1; // 将指针移动到上次出现的索引之后
            }
            max = Math.max(max, right - left + 1);
            map.put(c, right);
            right++;
        }
        return max;
    }

}
