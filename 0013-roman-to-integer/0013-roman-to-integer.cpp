class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> roman;
        roman['I'] = 1;
        roman['V'] = 5;
        roman['X'] = 10;
        roman['L'] = 50;
        roman['C'] = 100;
        roman['D'] = 500;
        roman['M'] = 1000;

        int n = s.length();
        int result = 0, i = 0;

        while (i < n) {
            if (i == n - 1) {
                result += roman[s[i]];
                i++;
            } else {
                if (roman[s[i]] < roman[s[i + 1]]) {
                    result += roman[s[i + 1]] - roman[s[i]];
                    i += 2;
                } else {
                    result += roman[s[i]];
                    i++;
                }
            }
        }

        return result;
    }
};