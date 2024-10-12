class Solution {
    public int minGroups(int[][] intervals) {
        int[] sortedStart = new int[intervals.length];
        int[] sortedEnd = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            sortedStart[i] = intervals[i][0];
            sortedEnd[i] = intervals[i][1];
        }

        Arrays.sort(sortedStart);
        Arrays.sort(sortedEnd);

        int result = 0, idx = 0;

        for (int start: sortedStart) {
            if (start > sortedEnd[idx]) {
                idx++;
            } else {
                result++;
            }
        }

        return result;
    }
}