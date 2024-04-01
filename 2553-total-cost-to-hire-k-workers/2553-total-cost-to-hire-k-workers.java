class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int lo = 0, hi = costs.length - 1;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long result = 0L;

        for (int i = 0; i < k; i++) {
            while (left.size() < candidates && lo <= hi) {
                left.add(costs[lo]);
                lo++;
            }
            while (right.size() < candidates && lo <= hi) {
                right.add(costs[hi]);
                hi--;
            }

            long left_cost = Long.MAX_VALUE, right_cost = Long.MAX_VALUE;

            if (!left.isEmpty()) left_cost = left.peek();
            if (!right.isEmpty()) right_cost = right.peek();

            if (left_cost <= right_cost) {
                result += left_cost;
                left.poll();
            } else {
                result += right_cost;
                right.poll();
            }
        }

        return result;
    }
}