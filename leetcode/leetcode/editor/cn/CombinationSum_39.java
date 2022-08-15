/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所
 * 有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 2112 👎 0
 */

package cn;

import cn.tools.RunTools;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    @Test
    public void runTest() {
        Solution solution = new CombinationSum_39().new Solution();
        Assert.assertEquals(RunTools.format("[[2,2,3],[7]]"), RunTools.int2dListToString(solution.combinationSum(RunTools.stringToIntegerArray("[2,3,6,7]"), 7)));
        Assert.assertEquals(RunTools.format("[[2,2,2,2],[2,3,3],[3,5]]"), RunTools.int2dListToString(solution.combinationSum(RunTools.stringToIntegerArray("[2,3,5]"), 8)));
        Assert.assertEquals(RunTools.format("[]"), RunTools.int2dListToString(solution.combinationSum(RunTools.stringToIntegerArray("[2]"), 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return Collections.emptyList();

            }

            List<List<Integer>> ans = new LinkedList<>();
            backtrack(candidates, target, 0, ans, new LinkedList<>(), 0);
            return ans;
        }

        private void backtrack(int[] nums, int target, int index, List<List<Integer>> ans, LinkedList<Integer> track, int sum) {
            if (sum == target) {
                ans.add(new LinkedList<>(track));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = index; i < nums.length; i++) {
                track.add(nums[i]);
                backtrack(nums, target, i, ans, track, sum + nums[i]);
                track.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}