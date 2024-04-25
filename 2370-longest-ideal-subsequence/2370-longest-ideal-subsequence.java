class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int target = s.charAt(i) - 'a';
            int longest = 0;
            for (int j = 0; j < 26; j++) {
                if (Math.abs(target - j) <= k) {
                    longest = Math.max(longest, 1 + dp[j]);
                }
            }
            dp[target] = longest;
        }

        int result = 0;

        for (int cnt: dp) {
            result = Math.max(result, cnt);
        }

        return result;
    }
}