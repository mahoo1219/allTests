/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 3446 👎 0
 */

package cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses_20 {
    @Test
    public void runTest() {
        Solution solution = new ValidParentheses_20().new Solution();
        Assert.assertEquals(true, solution.isValid("()"));
        Assert.assertEquals(true, solution.isValid("()[]{}"));
        Assert.assertEquals(false, solution.isValid("(]"));
        Assert.assertEquals(false, solution.isValid("([)]"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');

            LinkedList<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty() || stack.removeLast() != map.get(c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}