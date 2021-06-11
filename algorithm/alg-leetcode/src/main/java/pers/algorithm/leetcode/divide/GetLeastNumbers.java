package pers.algorithm.leetcode.divide;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GetLeastNumbers {

    /**
     * 分治法
     * <p>
     * 还没有做完，这个题用分治不太方便
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        return traversal(arr, k, 0, arr.length - 1);
    }

    private int[] traversal(int[] arr, int k, int l, int r) {
        int[] res = new int[k];
        if (l == r) {
            res[0] = arr[l];
            return res;
        }
        int mid = (l + r) / 2;
        int[] lRes = traversal(arr, k, l, mid);
        int[] rRes = traversal(arr, k, mid + 1, r);
        return merge(lRes, rRes, k);
    }

    private int[] merge(int[] lRes, int[] rRes, int k) {
        int[] res = new int[k];
        int l = 0, r = 0;
        for (int i = 0; i < res.length; i++) {
            if (lRes[l] < res[r]) {
                res[i] = lRes[l];
                l++;
            } else {
                res[i] = lRes[r];
                r++;
            }
        }
        return res;
    }
}
