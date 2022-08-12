/**
 * 有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID 。
 * <p>
 * 给定一个整数数组 groupSizes ，其中
 * groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1 个人必须位于大小为 3 的组中。
 * <p>
 * 返回一个组列表，使每个人 i 都在一个大小为
 * groupSizes[i] 的组中。
 * <p>
 * 每个人应该 恰好只 出现在 一个组 中，并且每个人必须在一个组中。如果有多个答案，返回其中 任何 一个。可以 保证 给定输入 至少有一个 有效的解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：groupSizes = [3,3,3,3,3,1,3]
 * 输出：[[5],[0,1,2],[3,4,6]]
 * 解释：
 * 第一组是 [5]，大小为 1，groupSizes[5] = 1。
 * 第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
 * 第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。
 * 其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：groupSizes = [2,1,3,3,3,2]
 * 输出：[[1],[0,5],[2,3,4]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * groupSizes.length == n
 * 1 <= n <= 500
 * 1 <= groupSizes[i] <= n
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 106 👎 0
 */

package cn;

import cn.tools.RunTools;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo_1282 {
    @Test
    public void runTest() {
        Solution solution = new GroupThePeopleGivenTheGroupSizeTheyBelongTo_1282().new Solution();
        Assert.assertEquals("[[5],[0,1,2],[3,4,6]]", RunTools.int2dListToString(solution.groupThePeople(RunTools.stringToIntegerArray("[3,3,3,3,3,1,3]"))));
        Assert.assertEquals("[[1],[0,5],[2,3,4]]", RunTools.int2dListToString(solution.groupThePeople(RunTools.stringToIntegerArray("[2,1,3,3,3,2]"))));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer, List<Integer>> groups = new HashMap<>();
            int n = groupSizes.length;
            for (int i = 0; i < n; i++) {
                int size = groupSizes[i];
                groups.putIfAbsent(size, new ArrayList<>());
                groups.get(size).add(i);
            }

            List<List<Integer>> groupList = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
                int size = entry.getKey();
                List<Integer> people = entry.getValue();
                int groupCount = people.size() / size;
                for (int i = 0; i < groupCount; i++) {
                    List<Integer> group = new ArrayList<>();
                    int start = i * size;
                    for (int j = 0; j < size; j++) {
                        group.add(people.get(start + j));
                    }
                    groupList.add(group);
                }
            }
            return groupList;
        }

        public List<List<Integer>> groupThePeople2(int[] groupSizes) {
            if (groupSizes == null || groupSizes.length == 0) {
                return Collections.emptyList();
            }

            int n = groupSizes.length;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = groupSizes[i];
                List<Integer> tmp = map.getOrDefault(num, new LinkedList<>());
                tmp.add(i);
                map.put(num, tmp);
            }
            List<List<Integer>> ans = new LinkedList<>();
            for (int i = 1; i <= groupSizes.length; i++) {
                List<Integer> tmp = map.get(i);
                if (tmp == null) {
                    continue;
                }
                split(ans, tmp, i);
            }
            return ans;
        }

        private void split(List<List<Integer>> ans, List<Integer> nums, int size) {
            List<Integer> temp = new ArrayList<>(size);
            while (nums.size() != 0) {
                while (temp.size() < size) {
                    temp.add(nums.remove(0));
                }
                ans.add(temp);
                temp = new ArrayList<>(size);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}