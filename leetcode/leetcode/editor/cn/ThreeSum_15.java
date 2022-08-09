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

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_15 {
    @Test
    public void runTest() {
        Solution solution = new ThreeSum_15().new Solution();
        Assert.assertEquals("[[-2, 0, 2],[-2, 1, 1]]", RunTools.int2dListToString(solution.threeSum(RunTools.stringToIntegerArray("[-2,0,1,1,2]"))));
        Assert.assertEquals("[[-1, -1, 2],[-1, 0, 1]]", RunTools.int2dListToString(solution.threeSum(RunTools.stringToIntegerArray("[-1,0,1,2,-1,-4]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new LinkedList<>();
            int n = nums.length;
            Arrays.sort(nums);

            for (int first = 0; first < n; first++) {
                if (first != 0 && nums[first] == nums[first - 1]) {
                    // same first num
                    continue;
                }

                int second = first + 1, third = n - 1;
                while (second < third) {
                    int val = nums[first] + nums[second] + nums[third];
                    if (val > 0) {
                        third--;
                    } else if (val < 0) {
                        second++;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[first], nums[second], nums[third]);
                        ans.add(temp);
                        second++;
                        third--;
                        while (second < third && nums[second] == nums[second - 1]) {
                            second++;
                        }
                        while (second < third && nums[third] == nums[third + 1]) {
                            third--;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}