class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] + i >= nums.length - 1) {
                dp[i] = true;
            } else {
                for (int j = i + 1; j < i + nums[i] + 1; j++) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}