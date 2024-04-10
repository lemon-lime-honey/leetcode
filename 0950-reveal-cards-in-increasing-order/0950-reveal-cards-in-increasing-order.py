class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        deck.sort()
        que = deque(range(len(deck)))
        result = [0 for i in range(len(deck))]

        for i in range(len(deck)):
            result[que.popleft()] = deck[i]
            if que:
                que.append(que.popleft())

        return  result