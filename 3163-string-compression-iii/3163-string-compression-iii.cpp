class Solution {
public:
    string compressedString(string word) {
        string result = "";
        int cnt = 1;

        for (int i = 1; i < word.length(); i++) {
            if (word[i] == word[i - 1]) {
                if (cnt == 9) {
                    result += to_string(cnt);
                    result += word[i - 1];
                    cnt = 1;
                } else {
                    cnt++;
                }
            } else {
                result += to_string(cnt);
                result += word[i - 1];
                cnt = 1;
            }
        }

        result += to_string(cnt);
        result += word[word.length() - 1];

        return result;
    }
};