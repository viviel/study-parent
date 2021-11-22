package pers.vv.study.alg.basic.sort;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] nums) {
        doSort(nums, 0, nums.length - 1);
    }

    private void doSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int partition = partition(nums, l, r);
        doSort(nums, l, partition - 1);
        doSort(nums, partition + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int split = l;
        int i = l + 1;
        int j = r;
        while (i < j) {
            while (i < j && nums[split] <= nums[j]) {
                j--;
            }
            while (i < j && nums[split] >= nums[i]) {
                i++;
            }
            swap(nums, i, j);
        }
        if (nums[split] > nums[i]) {
            swap(nums, l, i);
            split = i;
        }
        return split;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
