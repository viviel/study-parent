package pers.vv.study.alg.basic.sort;

import java.util.Random;

public class QuickSort2 extends QuickSort implements Sort {

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

    protected int partition(int[] nums, int l, int r) {
        randomPivot(nums, l, r);
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void randomPivot(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, r);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
