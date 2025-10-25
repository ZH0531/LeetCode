package LeetCodeHOT100;

import java.util.HashSet;
import java.util.Set;

public class No3 {
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
        int left = 0;
        int right = 1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length()) {
            while (right < s.length() && s.charAt(right) != s.charAt(left)&& !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left);
            left++;
            right = left + 1;
            set.clear();

        }
        return max;
    }

    public static void main(String[] args) {
        No3 no3 = new No3();
        System.out.println(no3.lengthOfLongestSubstring("abcabcbb"));
    }
}
