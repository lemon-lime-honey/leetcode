class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0, two = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            int temp = Math.min(one + cost[i - 1], two + cost[i - 2]);
            two = one;
            one = temp;
        }

        return one;
    }
}