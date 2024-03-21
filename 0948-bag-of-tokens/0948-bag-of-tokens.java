class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int result = 0, score = 0, lo = 0, hi = tokens.length - 1;
        Arrays.sort(tokens);

        while (lo <= hi) {
            if (tokens[lo] <= power) {
                power -= tokens[lo];
                score++;
                result = Math.max(result, score);
                lo++;
            } else if (score > 0) {
                power += tokens[hi];
                score--;
                hi--;
            } else {
                break;
            }
        }

        return result;
    }
}