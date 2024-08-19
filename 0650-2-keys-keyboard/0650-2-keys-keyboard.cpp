class Solution {
public:
    int minSteps(int n) {
        int result[n + 1];
        result[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            result[i] = i;
            for (int j = i / 2; j > 1; j--) {
                if (i % j == 0) {
                    result[i] = result[j] + i / j;
                    break;
                }
            }
        }

        return result[n];
    }
};