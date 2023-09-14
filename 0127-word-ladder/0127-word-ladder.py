from collections import defaultdict, deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0

        nb = defaultdict(list)
        wordList.append(beginWord)

        for word in wordList:
            for j in range(len(word)):
                pat = word[:j] + '*' + word[j + 1:]
                nb[pat].append(word)

        visited = set([beginWord])
        que = deque([beginWord])
        result = 1

        while que:
            n = len(que)
            for i in range(n):
                word = que.popleft()
                if word == endWord: return result
                for j in range(len(word)):
                    pat = word[:j] + '*' + word[j + 1:]
                    for elem in nb[pat]:
                        if elem not in visited:
                            visited.add(elem)
                            que.append(elem)
            result += 1

        return 0