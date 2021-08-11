package pers.algorithm.leetcode.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个大小在 (0, 0) 到 (N-1, N-1) 的2D网格grid中，除了在mines中给出的单元为0，其他每个单元都是1。
 * 网格中包含1的最大的轴对齐加号标志是多少阶？返回加号标志的阶数。如果未找到加号标志，则返回 0。
 * <p>
 * 一个k" 阶由1组成的“轴对称”加号标志具有中心网格grid[x][y] = 1，以及4个从中心向上、向下、向左、向右延伸，长度为k-1，由1组成的臂。
 * 下面给出k" 阶“轴对称”加号标志的示例。注意，只有加号标志的所有网格要求为 1，别的网格可能为 0 也可能为 1。
 * <p>
 * <p>
 * <p>
 * k 阶轴对称加号标志示例:
 * <p>
 * 阶 1:
 * 000
 * 010
 * 000
 * <p>
 * 阶 2:
 * 00000
 * 00100
 * 01110
 * 00100
 * 00000
 * <p>
 * 阶 3:
 * 0000000
 * 0001000
 * 0001000
 * 0111110
 * 0001000
 * 0001000
 * 0000000
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: N = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释:
 * <p>
 * 11111
 * 11111
 * 11111
 * 11111
 * 11011
 * <p>
 * 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: N = 2, mines = []
 * 输出: 1
 * 解释:
 * <p>
 * 11
 * 11
 * <p>
 * 没有 2 阶加号标志，有 1 阶加号标志。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入: N = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释:
 * <p>
 * 0
 * <p>
 * 没有加号标志，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 整数N 的范围：[1, 500].
 * mines 的最大长度为5000.
 * mines[i] 是长度为2的由2个[0, N-1]中的数组成.
 * (另外,使用 C, C++, 或者C# 编程将以稍小的时间限制进行判断.)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-plus-sign
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class OrderOfLargestPlusSign {

    /**
     * 暴力解法
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        for (int[] mine : mines) {
            banned.add(mine[0] * N + mine[1]);
        }

        int ans = 0;
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                int k = 0;
                while (k <= r && r < N - k &&
                        k <= c && c < N - k &&
                        !banned.contains((r - k) * N + c) &&
                        !banned.contains((r + k) * N + c) &&
                        !banned.contains(r * N + c - k) &&
                        !banned.contains(r * N + c + k)
                ) {
                    k++;
                }

                ans = Math.max(ans, k);
            }
        }
        return ans;
    }
}
