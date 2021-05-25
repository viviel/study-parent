package pers.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例 1
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class DivingBoard {

    private final List<Integer> l = new ArrayList<>();

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        traversal(shorter, longer, k, 0);
        int[] r = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            r[i] = l.get(i);
        }
        return r;
    }

    private void traversal(int shorter, int longer, int k, int length) {
        if (k <= 0) {
            l.add(length);
            return;
        }
        traversal(shorter, longer, k - 1, length + shorter);
        traversal(shorter, longer, k - 1, length + longer);
    }

    public int[] divingBoard2(int shorter, int longer, int k) {
        // 木板数量小于1，无解
        if (k < 1) {
            return new int[]{};
        }
        // 两块板子长度一样只有一种解
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        // 枚举较长木板的数量，那么（k-i）即是短板的数量
        for (int i = 0; i <= k; i++) {
            res[i] = longer * i + shorter * (k - i);
        }
        return res;
    }
}
