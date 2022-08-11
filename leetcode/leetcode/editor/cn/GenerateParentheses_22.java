/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * Related Topics 字符串 动态规划 回溯 👍 2801 👎 0
 */

package cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses_22 {
    @Test
    public void runTest() {
        Solution solution = new GenerateParentheses_22().new Solution();
        Assert.assertEquals(5, solution.generateParenthesis(3).size());
        Assert.assertEquals(1, solution.generateParenthesis(1).size());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return Collections.emptyList();
            }
            List<String> ans = new LinkedList<>();
            backward(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }


        private void backward(List<String> ans, StringBuilder sb, int open, int close, int n) {
            if (sb.length() == 2 * n) {
                ans.add(sb.toString());
                return;
            }

            if (open < n) {
                sb.append("(");
                backward(ans, sb, open + 1, close, n);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close < open) {
                sb.append(")");
                backward(ans, sb, open, close + 1, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}