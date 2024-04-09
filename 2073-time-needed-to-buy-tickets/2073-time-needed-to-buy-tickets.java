class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                result += Math.min(tickets[i], tickets[k]);
            } else {
                result += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return result;
    }
}