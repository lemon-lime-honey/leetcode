class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int now = 1, before = 1;

        for (int i = 1; i < n; i++) {
            int temp = now;
            now = temp + before;
            before = temp;
        }

        return now;
    }
}