class Solution {
public:
    int lengthOfLastWord(string s) {
        int result = 0;
        bool flag = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s[i] != ' ') {
                result++;
                flag = true;
            } else if (flag) {
                break;
            }
        }

        return result;
    }
};