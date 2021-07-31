package pers.vv.study.common;

public class MathUtils {

    public static int min(int... arr) {
        if (arr.length < 2) {
            return arr[0];
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
