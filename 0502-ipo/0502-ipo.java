class Pair implements Comparable<Pair> {
    public int c;
    public int p;

    public Pair(int c, int p) {
        this.c = c;
        this.p = p;
    }

    public int compareTo(Pair o) {
        if (this.c < o.c) return -1;
        else if (this.c == o.c) return 0;
        return 1;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Pair> minCapital = new PriorityQueue<>();

        for (int i = 0; i < profits.length; i++) {
            minCapital.offer(new Pair(capital[i], profits[i]));
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek().c <= w) {
                maxProfit.offer(minCapital.poll().p);
            }

            if (maxProfit.isEmpty()) break;
            w += maxProfit.poll();
        }

        return w;
    }
}