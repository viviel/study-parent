package pers.algorithm.leetcode.array;

/**
 * 这里有n个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [first_i, last_i, seats_i]
 * 意味着在从 first_i到 last_i （包含 first_i 和 last_i ）的 每个航班 上预订了 seats_i个座位。
 * <p>
 * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 * 1 <= bookings.length <= 2 * 10^4
 * bookings[i].length == 3
 * 1 <= first_i <= last_i <= n
 * 1 <= seats_i <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] sum = new int[n];
        for (int[] booking : bookings) {
            int f = booking[0];
            int l = booking[1];
            int s = booking[2];
            for (int i = f; i <= l; i++) {
                sum[i - 1] += s;
            }
        }
        return sum;
    }
}
