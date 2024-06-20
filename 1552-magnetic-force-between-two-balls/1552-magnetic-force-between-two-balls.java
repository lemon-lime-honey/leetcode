class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = position[position.length - 1], result = 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int now = position[0], cnt = 1;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - now >= mid) {
                    cnt++;
                    now = position[i];
                }
            }
            if (m <= cnt) {
                result = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }
}