class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numDict;
        vector<int> result(2, 0);

        for (int i = 0; i < nums.size(); i++) {
            numDict.insert({nums[i], i});
        }

        for (int i = 0; i < nums.size(); i++) {
            unordered_map<int, int>::const_iterator chk = numDict.find(target - nums[i]);
            if (chk != numDict.end() && chk->second != i) {
                result[0] = i;
                result[1] = chk->second;
                break;
            }
        }

        return result;
    }
};