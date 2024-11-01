class Solution {
public:
    string makeFancyString(string s) {
        string result = "";
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s[i] != s[i - 1]) {
                result += s[i];
                cnt = 1;
            } else if (cnt == 2) {
                continue;
            } else {
                result += s[i];
                cnt++;
            }
        }

        return result;
    }
};