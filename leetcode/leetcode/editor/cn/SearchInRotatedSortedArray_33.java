/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+
 * 1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4
 * ,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5000
 * -10⁴ <= nums[i] <= 10⁴
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 2253 👎 0
 */

package cn;

import cn.tools.RunTools;
import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArray_33 {
    @Test
    public void runTest() {
        Solution solution = new SearchInRotatedSortedArray_33().new Solution();
        Assert.assertEquals(4, solution.search(RunTools.stringToIntegerArray("[4,5,6,7,0,1,2]"), 0));
        Assert.assertEquals(-1, solution.search(RunTools.stringToIntegerArray("[4,5,6,7,0,1,2]"), 3));
        Assert.assertEquals(-1, solution.search(RunTools.stringToIntegerArray("[1]"), 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[lo] <= nums[mid]) {
                    // 升序
                    if (nums[lo] <= target && target < nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else if (nums[lo] > nums[mid]) {
                    if (nums[mid] < target && target <= nums[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}