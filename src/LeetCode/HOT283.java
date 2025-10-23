package LeetCode;

public class HOT283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * <p>
     * 进阶：你能尽量减少完成的操作次数吗？
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n != 0 && n != 1) {
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];//先赋值，再index++
                }
            }
            while (index < n) {
                nums[index++] = 0;
            }
        }
    }
}
