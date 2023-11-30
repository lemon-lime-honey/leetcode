class Solution {
    public int climbStairs(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(2);

        for (int i = 2; i < n; i++) {
            dp.add(dp.get(dp.size() - 1) + dp.get(dp.size() - 2));
        }

        return dp.get(n - 1);
    }
}