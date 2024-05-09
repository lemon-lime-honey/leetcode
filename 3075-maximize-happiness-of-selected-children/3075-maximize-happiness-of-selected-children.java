class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length, decay = 0;
        long result = 0L;

        for (int i = n - 1; i >= n - k; i--) {
            result += Math.max(happiness[i] - decay, 0);
            decay += 1;
        }

        return result;
    }
}