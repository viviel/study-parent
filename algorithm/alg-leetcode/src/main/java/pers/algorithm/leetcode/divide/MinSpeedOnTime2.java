package pers.algorithm.leetcode.divide;

import java.util.Arrays;

class MinSpeedOnTime2 extends MinSpeedOnTime {

    @Override
    public int minSpeedOnTime(int[] dist, double hour) {
        int i = 1;//最小速度
        int j = Arrays.stream(dist).max().getAsInt() * 100;//最大速度
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (costtime(m, dist) > hour) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i > Arrays.stream(dist).max().getAsInt() * 100 ? -1 : i;
    }

    public double costtime(double speed, int[] dist) {
        int len = dist.length;
        double result = 0;
        for (int i = 0; i < len - 1; i++) {
            result += Math.ceil(dist[i] / speed);
        }
        return result + dist[len - 1] / speed;
    }

    @Override
    protected double duration(int[] dist, int speed) {
        return costtime(speed, dist);
    }
}
