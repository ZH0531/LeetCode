package LeetCode.HOT100;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class No128 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * 示例 3：
     * <p>
     * 输入：nums = [1,0,1,2]
     * 输出：3
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        Arrays.sort(nums);
        Set<Integer> numSet = new LinkedHashSet<>();
        Arrays.stream(nums).forEach(numSet::add);
        int count = 1;
        int max = 1;
        for (int num : numSet) {
            if (numSet.contains(num + 1)) count++;
            else {
                max = Math.max(max, count);
                if (numSet.size() - max <= max) break;
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
}
