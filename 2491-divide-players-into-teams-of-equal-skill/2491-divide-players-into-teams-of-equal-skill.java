class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ref = skill[0] + skill[skill.length - 1];
        long result = skill[0] * skill[skill.length - 1];
        int lo = 1, hi = skill.length - 2;

        while (lo < hi) {
            long chk = skill[lo] + skill[hi];
            if (chk != ref) return -1;
            result += skill[lo] * skill[hi];
            lo++;
            hi--;
        }

        return result;
    }
}