/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母和/或数字组成。
 * <p>
 * <p>
 * Related Topics 字符串 👍 82 👎 0
 */

package cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class ReformatTheString_1417 {
    @Test
    public void runTest() {
        Solution solution = new ReformatTheString_1417().new Solution();
        Assert.assertEquals("a0b1c2", solution.reformat("a0b1c2"));
        Assert.assertEquals("c2o0v1i9d", solution.reformat("covid2019"));
        Assert.assertEquals("1a2b3", solution.reformat("ab123"));
        Assert.assertEquals("", solution.reformat("leetcode"));
        Assert.assertEquals("", solution.reformat("1229857369"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            LinkedList<Character> alphas = new LinkedList<>();
            LinkedList<Character> digits = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    digits.add(c);
                } else {
                    alphas.add(c);
                }
            }
            if (Math.abs(alphas.size() - digits.size()) > 1) {
                return "";
            }

            int alphaNum = alphas.size();
            int digitNum = digits.size();
            StringBuilder sb = new StringBuilder();
            if (alphaNum > digitNum) {
                while (digits.size() != 0) {
                    sb.append(alphas.removeFirst()).append(digits.removeFirst());
                }
                sb.append(alphas.removeFirst());
            } else if (alphaNum < digitNum) {
                while (alphas.size() != 0) {
                    sb.append(digits.removeFirst()).append(alphas.removeFirst());
                }
                sb.append(digits.removeFirst());
            } else {
                while (alphas.size() != 0) {
                    sb.append(alphas.removeFirst()).append(digits.removeFirst());
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}