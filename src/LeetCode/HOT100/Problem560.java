package LeetCode.HOT100;

public class Problem560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * <p>
     * 子数组是数组中元素的连续非空序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == k ? 1 : 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < nums.length) {
            while (sum < k) {
                sum += nums[right];
                right++;
            }
            while (sum > k && left < right) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                count++;
                sum -= nums[left];
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1}; // 错误案例！本题不应该使用滑动窗口，滑动窗口面临负数会失效
        int k = 0;
        System.out.println(new Problem560().subarraySum(nums, k));
    }
}
