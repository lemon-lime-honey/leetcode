class Solution {
public:
    int countMatches(vector<vector<string>>& items, string ruleKey, string ruleValue) {
        int result = 0;

        for (auto item: items) {
            if (ruleKey == "type" && item[0] == ruleValue) result++;
            else if (ruleKey == "color" && item[1] == ruleValue) result++;
            else if (ruleKey == "name" && item[2] == ruleValue) result++;
        }

        return result;
    }
};