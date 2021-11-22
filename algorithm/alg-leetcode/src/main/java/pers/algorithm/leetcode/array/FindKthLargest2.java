package pers.algorithm.leetcode.array;

class FindKthLargest2 extends FindKthLargest {

    @Override
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    private int find(int[] nums, int k, int l, int r) {
        int partition = partition(nums, l, r);
        if (r - partition == k - 1) {
            return nums[partition];
        } else if (r - partition < k - 1) {
            //left
            return find(nums, k - 1 - (r - partition), l, partition - 1);
        } else {
            //right
            return find(nums, k, partition + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int partition = l;
        int i = l + 1;
        int j = r;
        while (i < j) {
            while (i < j && nums[partition] <= nums[j]) {
                j--;
            }
            while (i < j && nums[partition] >= nums[i]) {
                i++;
            }
            swap(nums, i, j);
        }
        if (nums[partition] > nums[i]) {
            swap(nums, partition, i);
            partition = i;
        }
        return partition;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
