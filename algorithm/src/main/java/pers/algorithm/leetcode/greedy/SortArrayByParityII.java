
package pers.algorithm.leetcode.greedy;

/**
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SortArrayByParityII {

    /**
     * O(n)
     * O(n)
     */
    public int[] sortArrayByParityII(int[] a) {
        int[] aj = new int[a.length / 2];
        int[] ao = new int[a.length / 2];
        int i = 0, j = 0;
        for (int e : a) {
            if (e % 2 != 0) {
                aj[i++] = e;
            } else {
                ao[j++] = e;
            }
        }
        i = 0;
        j = 0;
        for (int k = 0; k < a.length; k++) {
            if (k % 2 == 0) {
                a[k] = ao[j++];
            } else {
                a[k] = aj[i++];
            }
        }
        return a;
    }

    /**
     * O(n^2)
     * O(1)
     */
    public int[] sortArrayByParityII2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (illegalO(i, a[i])) {
                for (int j = i + 1; j < a.length; j++) {
                    if (illegalJ(j, a[j])) {
                        swap(a, i, j);
                        break;
                    }
                }
            } else if (illegalJ(i, a[i])) {
                for (int j = i + 1; j < a.length; j++) {
                    if (illegalO(j, a[j])) {
                        swap(a, i, j);
                        break;
                    }
                }
            }
        }
        return a;
    }

    private boolean illegalO(int i, int v) {
        return (i & 1) == 0 && (i & 1) != (v & 1);
    }

    private boolean illegalJ(int i, int v) {
        return (i & 1) == 1 && (i & 1) != (v & 1);
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * O(n)
     * O(1)
     */
    public int[] sortArrayByParityII3(int[] a) {
        int i = 0, j = 1;
        while (i < a.length && j < a.length) {
            if ((a[i] & 1) == 0) {
                i += 2;
            } else if ((a[j] & 1) == 1) {
                j += 2;
            } else {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return a;
    }
}