class Solution {
public:
    int minSwaps(string s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '[') {
                result++;
            } else if (result > 0) {
                result--;
            }
        }

        return (result + 1) / 2;
    }
};