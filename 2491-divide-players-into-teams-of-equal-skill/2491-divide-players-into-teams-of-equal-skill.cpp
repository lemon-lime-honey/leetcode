class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        sort(skill.begin(), skill.end());
        int ref = skill[0] + skill[skill.size() - 1];
        int lo = 1, hi = skill.size() - 2;
        long long result = skill[0] * skill[skill.size() - 1];

        while (lo < hi) {
            int chk = skill[lo] + skill[hi];
            if (chk != ref) return -1;
            result += skill[lo] * skill[hi];
            lo++;
            hi--;
        }

        return result;
    }
};