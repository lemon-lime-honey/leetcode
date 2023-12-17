class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int chk = 0;
        for (int i = 0; i < gas.length; i++) {
            chk += gas[i] - cost[i];
        }
        if (chk < 0) {
            return -1;
        }

        int total = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }
}