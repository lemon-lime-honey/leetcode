class Pair implements Comparable<Pair> {
    int score;
    int index;

    public Pair(int score, int index) {
        this.score = score;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p) {
        return this.score <= p.score ? 1 : -1;
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> que = new PriorityQueue<>();
        String[] result = new String[score.length];
        Map<Integer, String> message = new HashMap<>();

        message.put(0, "Gold Medal");
        message.put(1, "Silver Medal");
        message.put(2, "Bronze Medal");

        for (int i = 0; i < score.length; i++) {
            que.offer(new Pair(score[i], i));
        }

        for (int i = 0; i < score.length; i++) {
            if (message.containsKey(i)) {
                result[que.poll().index] = message.get(i);
            } else {
                result[que.poll().index] = (i + 1) + "";
            }
        }

        return result;
    }
}