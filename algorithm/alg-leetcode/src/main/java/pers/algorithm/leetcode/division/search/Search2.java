package pers.algorithm.leetcode.division.search;

class Search2 extends Search {

    @Override
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int split = findSplit(nums);
        if (split != 0) {
            if (nums[0] <= target) {
                r = split - 1;
            } else {
                l = split;
            }
        }
        return findTarget(nums, target, l, r);
    }

    int findSplit(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l < r && nums[l] > nums[r]) {
            int mid = (l + r) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[l] > nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int findTarget(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
