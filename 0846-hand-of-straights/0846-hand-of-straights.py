class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize: return False
        result = [[] for i in range(len(hand) // groupSize)]
        hand.sort()

        for num in hand:
            for res in result:
                if not res or res[-1] + 1 == num and len(res) < groupSize:
                    res.append(num)
                    break
            else: return False

        return True