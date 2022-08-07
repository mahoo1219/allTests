/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的
 * 三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 3000
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 5088 👎 0
 */

package cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ThreeSum_15 {
    @Test
    public void runTest() {
        Solution solution = new ThreeSum_15().new Solution();
        Assert.assertEquals("[[-1,-1,2],[-1,0,1]]", RunTools.int2dListToString(solution.threeSum(RunTools.stringToIntegerArray("[-1,0,1,2,-1,-4]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return Collections.emptyList();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}