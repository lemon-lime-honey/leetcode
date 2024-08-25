class Solution {
public:
    vector<int> findArray(vector<int>& pref) {
        vector<int> result(pref.size(), pref[0]);
        int now = pref[0];

        for (int i = 1; i < pref.size(); i++) {
            result[i] = now ^ pref[i];
            now = pref[i];
        }

        return result;
    }
};