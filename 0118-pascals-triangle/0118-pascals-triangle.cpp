class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> result;

        for (int i = 0; i < numRows; i++) {
            vector<int> temp;
            temp.push_back(1);

            if (!result.empty()) {
                for (int j = 0; j < i - 1; j++) {
                    int target = result.back()[j] + result.back()[j + 1];
                    temp.push_back(target);
                }
                temp.push_back(1);
            }

            result.push_back(temp);
        }

        return result;
    }
};