class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result(1, 1);

        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                result[j] = result[j] + result[j - 1];
            }
            result.push_back(1);
        }

        return result;
    }
};