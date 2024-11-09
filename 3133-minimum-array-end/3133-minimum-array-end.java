class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long cnt = n - 1;
        long pos = 1;

        while (cnt > 0) {
            if ((x & pos) == 0) {
                result |= (cnt & 1) * pos;
                cnt >>= 1;
            }
            pos <<= 1;
        }

        return result;
    }
}