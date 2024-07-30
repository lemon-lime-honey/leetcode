class Solution {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length() + 1];
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                dp[i + 1] = Math.min(dp[i] + 1, cnt);
            } else {
                dp[i + 1] = dp[i];
                cnt++;
            }
        }

        return dp[s.length()];
    }
}