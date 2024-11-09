class Solution {
public:
    long long minEnd(int n, int x) {
        long long result = x;
        long cnt = n - 1;
        long pos = 1;

        while (cnt) {
            if (!(x & pos)) {
                result |= (cnt & 1) * pos;
                cnt >>= 1;
            }
            pos <<= 1;
        }

        return result;
    }
};