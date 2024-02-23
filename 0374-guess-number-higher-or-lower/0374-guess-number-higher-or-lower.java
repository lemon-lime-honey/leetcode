public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int chk = guess(mid);
            if (chk == 0) {
                return mid;
            }
            if (chk == -1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}