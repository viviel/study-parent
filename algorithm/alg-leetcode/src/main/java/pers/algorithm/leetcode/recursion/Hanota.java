package pers.algorithm.leetcode.recursion;

import java.util.List;
import java.util.Stack;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Hanota {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        Stack<Integer> a = new Stack<>();
        for (Integer integer : A) {
            a.push(integer);
        }
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();
        traversal(n, a, b, c);
        C.addAll(c);
    }

    private void traversal(int n, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (n == 1) {
            c.push(a.pop());
            return;
        }
        traversal(n - 1, a, c, b);
        c.push(a.pop());
        traversal(n - 1, b, a, c);
    }
}
