class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int n = deck.length;
        Deque<Integer> que = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            que.addLast(i);
        }

        for (int i = 0; i < n; i++) {
            result[que.pollFirst()] = deck[i];
            if (!que.isEmpty()) {
                que.addLast(que.pollFirst());
            }
        }

        return result;
    }
}