class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int ref = points[0][1];
        int result = 1;

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > ref) {
                result++;
                ref = points[i][1];
            } else {
                ref = Math.min(ref, points[i][1]);
            }
        }

        return result;
    }
}