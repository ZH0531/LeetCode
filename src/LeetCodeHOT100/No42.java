package LeetCodeHOT100;

public class No42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     */
    public int trap(int[] height) {
        int left = 0; //左指针
        int right = height.length - 1; //右指针
        int count = 1; //正在统计的层数
        int result = 0; //结果
        while (left < right) {
            while (height[left] < count && left < right) left++; //找到当前层最左边的柱子
            while (height[right] < count && left < right) right--; //找到当前层最右边的柱子
            for (int i = left+1; i < right; i++) {
                if (height[i] < count ) result++; //统计当前层 如果有小于当前层高的柱子 就加1
            }
            count++; //层数加1
        }
        return result;
    }

    public static void main(String[] args) {
        No42 no42 = new No42();
        System.out.println(no42.trap(new int[]{2,0,2}));
    }
}
