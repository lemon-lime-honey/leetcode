class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int most = 0, maximum = 0;

        for (char c: tasks) {
            cnt[c - 'A']++;
            if (maximum == cnt[c - 'A']) {
                most++;
            } else if (maximum < cnt[c - 'A']) {
                maximum = cnt[c - 'A'];
                most = 1;
            }
        }

        int result = (maximum - 1) * (n + 1) + most;
        return Math.max(result, tasks.length);
    }
}