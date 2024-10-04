class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()
        ref = skill[0] + skill[-1]
        lo, hi = 1, len(skill) - 2
        result = skill[0] * skill[-1]

        while lo < hi:
            chk = skill[lo] + skill[hi]
            if chk != ref:
                return -1
            result += skill[lo] * skill[hi]
            lo += 1
            hi -= 1

        return result