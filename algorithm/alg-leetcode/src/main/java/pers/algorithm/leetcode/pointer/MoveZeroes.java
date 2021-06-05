package pers.algorithm.leetcode.pointer;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length && i <= j) {
            if (nums[i] != 0) {
                i++;
                j = i + 1;
                continue;
            }
            if (nums[j] == 0) {
                j++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    /**
     * 思路：设置一个index，表示非0数的个数，循环遍历数组，
     * 如果不是0，将非0值移动到第index位置,然后index + 1
     * 遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
     * <p>
     * [0,1,0,3,12]
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
