package pers.algorithm.leetcode.dynamic;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1 && i == m - 1) {
                    pathNum[i][j] = 1;
                } else if (i == m - 1) {
                    pathNum[i][j] = pathNum[i][j + 1];
                } else if (j == n - 1) {
                    pathNum[i][j] = pathNum[i + 1][j];
                } else {
                    pathNum[i][j] = pathNum[i + 1][j] + pathNum[i][j + 1];
                }
            }
        }
        return pathNum[0][0];
    }
}
