package pers.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和arr2，
 * <p>
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * <p>
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2中的元素arr2[i]各不相同
 * arr2 中的每个元素arr2[i]都出现在arr1中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int i = 0;
        for (int e : arr2) {
            for (; i < arr1.length; i++) {
                if (arr1[i] == e) {
                    continue;
                }
                int j = i + 1;
                for (; j < arr1.length; j++) {
                    if (arr1[j] == e) {
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                        break;
                    }
                }
                if (j == arr1.length) {
                    break;
                }
            }
        }
        Arrays.sort(arr1, i, arr1.length);
        return arr1;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] hash1 = new int[1001];
        int[] hash2 = new int[1001];
        for (int e : arr2) {
            hash2[e]++;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (hash2[arr1[i]] != 0) {
                hash1[arr1[i]]++;
                arr1[i] = 0;
            }
        }
        Arrays.sort(arr1);
        int i = 0;
        for (int e : arr2) {
            while (0 != hash1[e]) {
                arr1[i] = e;
                i++;
                hash1[e]--;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        int[] hash = new int[1001];
        for (int j : arr1) {
            hash[j]++;
        }
        int i = 0;
        for (int e : arr2) {
            while (0 != hash[e]) {
                arr1[i] = e;
                i++;
                hash[e]--;
            }
        }
        for (int j = 0; j < hash.length; ) {
            if (hash[j] == 0) {
                j++;
                continue;
            }
            arr1[i] = j;
            hash[j]--;
            i++;
        }
        return arr1;
    }
}