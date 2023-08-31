class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        sdict = dict()
        tdict = dict()
        ref = 0

        for i in range(len(s)):
            if s[i] not in sdict and t[i] not in tdict:
                sdict[s[i]] = ref
                tdict[t[i]] = ref
                ref += 1
            elif s[i] not in sdict or t[i] not in tdict: break
            else:
                if sdict[s[i]] != tdict[t[i]]: break
        else: return True
        return False