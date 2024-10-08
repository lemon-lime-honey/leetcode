class Solution {
public:
    string convertToTitle(int columnNumber) {
        string result = "";
        while (columnNumber > 0) {
            int idx = (columnNumber - 1) % 26;
            result = (char)('A' + idx) + result;
            columnNumber = (columnNumber - 1) / 26;
        }
        return result;
    }
};