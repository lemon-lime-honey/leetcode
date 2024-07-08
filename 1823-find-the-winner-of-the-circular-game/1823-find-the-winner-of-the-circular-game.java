class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            que.add(i);
        }

        while (que.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                que.add(que.poll());
            }
            que.poll();
        }

        return que.poll();
    }
}