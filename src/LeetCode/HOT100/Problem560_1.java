package LeetCode.HOT100;

import java.util.HashMap;
import java.util.Map;

public class Problem560_1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(new Problem560_1().subarraySum(nums, k));
    }
}
