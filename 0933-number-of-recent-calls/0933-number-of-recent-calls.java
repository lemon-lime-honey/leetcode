class RecentCounter {
    Queue<Integer> que;

    public RecentCounter() {
        que = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        while (!que.isEmpty() && t - que.peek() > 3000) {
            que.poll();
        }
        que.add(t);
        return que.size();
    }
}
