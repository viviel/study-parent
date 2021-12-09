package pers.algorithm.leetcode.dynamic;

class Jump2 extends Jump {

    @Override
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                temp[i] = -1;
            } else {
                temp[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (temp[j] < 0) {
                    continue;
                }
                temp[i] = Math.min(temp[i], 1 + temp[j]);
            }
            if (temp[i] == Integer.MAX_VALUE) {
                temp[i] = -1;
            }
        }
        return temp[0];
    }
}
