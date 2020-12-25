package pers.algorithm.leetcode.greedy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为(r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * <p>
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class AllCellsDistOrder {

    public int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
        class Node {
            final int key;
            final int[] value;

            Node(int key, int[] value) {
                this.key = key;
                this.value = value;
            }
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                list.add(new Node(Math.abs(i - r0) + Math.abs(j - c0), new int[]{i, j}));
            }
        }
        int[][] result = new int[list.size()][2];
        final AtomicInteger i = new AtomicInteger();
        list.stream()
                .sorted(Comparator.comparingInt(e -> e.key))
                .forEach(e -> {
                    result[i.get()] = e.value;
                    i.set(i.get() + 1);
                });
        return result;
    }

    public int[][] allCellsDistOrder2(int r, int c, int r0, int c0) {
        int[][] result = new int[r * c][2];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[index++] = new int[]{i, j};
            }
        }
        Arrays.sort(result, Comparator.comparing(e -> Math.abs(e[0] - r0) + Math.abs(e[1] - c0)));
        return result;
    }

    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++) {
                int[] xy = {i, j};
                res[index++] = xy;
            }
        Arrays.sort(res, (o1, o2) -> {
            int dis1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int dis2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return dis1 - dis2;
        });
        return res;
    }
}