class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        result = [0 for i in range(len(pref))]
        result[0] = pref[0]
        now = pref[0]

        for i in range(1, len(pref)):
            result[i] = now ^ pref[i]
            now = pref[i]

        return result