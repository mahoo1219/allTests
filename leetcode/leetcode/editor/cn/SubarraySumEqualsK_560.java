/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * -1000 <= nums[i] <= 1000
 * -10⁷ <= k <= 10⁷
 * <p>
 * <p>
 * Related Topics 数组 哈希表 前缀和 👍 1643 👎 0
 */

package cn;

import cn.tools.RunTools;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
    @Test
    public void runTest() {
        Solution solution = new SubarraySumEqualsK_560().new Solution();
        Assert.assertEquals(2, solution.subarraySum(RunTools.stringToIntegerArray("[1,1,1]"), 2));
        Assert.assertEquals(2, solution.subarraySum(RunTools.stringToIntegerArray("[1,2,3]"), 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int count = 0, pre = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int num : nums) {
                pre += num;
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}