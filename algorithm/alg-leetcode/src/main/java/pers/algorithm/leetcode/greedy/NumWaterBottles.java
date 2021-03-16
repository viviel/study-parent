package pers.algorithm.leetcode.greedy;

/**
 * https://leetcode-cn.com/problems/water-bottles/
 */
class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int tb = numBottles;
        while (tb >= numExchange) {
            result += tb / numExchange;
            tb = tb % numExchange + tb / numExchange;
        }
        return result;
    }
}