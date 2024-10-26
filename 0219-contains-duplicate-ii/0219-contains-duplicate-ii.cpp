class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> indices;

        for (int i = 0; i < nums.size(); i++) {
            if (indices.find(nums[i]) != indices.end()) {
                if (i - indices[nums[i]] <= k) return true;
            }
            indices[nums[i]] = i;
        }

        return false;
    }
};