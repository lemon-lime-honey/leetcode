class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int[] chk = new int[3];

        for (int num: nums) {
            que.add(num);
        }

        while (que.size() != 0) {
            int now = que.poll();
            if (chk[2] == 0) {
                chk[0] = now;
                chk[1] = 1;
                chk[2] = 1;
            } else {
                if (now == chk[0] + 1) {
                    chk[0] = now;
                    chk[1]++;
                    chk[2] = Math.max(chk[2], chk[1]);
                } else if (now == chk[0]) {
                    continue;
                } else {
                    chk[0] = now;
                    chk[1] = 1;
                }
            }
        }

        return chk[2];
    }
}