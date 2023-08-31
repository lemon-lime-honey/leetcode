from collections import Counter


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = list()
        words = dict()

        for word in strs:
            words[word] = sorted(Counter(word).most_common())

        for word in strs:
            if not result:
                result.append([word])
            else:
                for lis in result:
                    if words[word] == words[lis[-1]]:
                        lis.append(word)
                        break
                else:
                    result.append([word])
        return result