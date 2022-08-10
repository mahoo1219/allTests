/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * <p>
 * Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2101 👎 0
 */

package cn;

import cn.tools.ListNode;
import org.junit.Test;

public class MergeKSortedLists_23 {
    @Test
    public void runTest() {
        Solution solution = new MergeKSortedLists_23().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            int n = lists.length;
            ListNode[] tempLists = new ListNode[(n + 1) / 2];
            int index = 0;
            while (index < (n + 1) / 2) {
                ListNode l1 = lists[2 * index];
                ListNode l2 = 2 * index + 1 >= n ? null : lists[2 * index + 1];
                tempLists[index] = merge2Lists(l1, l2);
                index++;
            }
            return mergeKLists2(tempLists);
        }

        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return merge2Lists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        private ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val <= l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            }
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}