class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()
        patdict = dict()
        worddict = dict()

        if len(pattern) == len(words):
            for i in range(len(pattern)):
                if pattern[i] not in patdict and words[i] not in worddict:
                    patdict[pattern[i]] = words[i]
                    worddict[words[i]] = pattern[i]
                elif pattern[i] not in patdict or words[i] not in worddict:
                    break
                else:
                    if patdict[pattern[i]] != words[i]: break
                    if worddict[words[i]] != pattern[i]: break
            else: return True
        return False