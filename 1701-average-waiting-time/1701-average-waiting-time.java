class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = customers[0][0];
        double total = 0;

        for (int i = 0; i < customers.length; i++) {
            if (time <= customers[i][0]) {
                total += customers[i][1];
                time = customers[i][0] + customers[i][1];
            } else {
                total += time + customers[i][1] - customers[i][0];
                time += customers[i][1];
            }
        }

        return total / customers.length;
    }
}