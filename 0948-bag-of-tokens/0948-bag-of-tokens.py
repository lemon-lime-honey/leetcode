class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        result, score = 0, 0
        lo, hi = 0, len(tokens) - 1
        tokens.sort()

        while lo <= hi:
            if tokens[lo] <= power:
                power -= tokens[lo]
                score += 1
                result = max(result, score)
                lo += 1
            elif score > 0:
                power += tokens[hi]
                score -= 1
                hi -= 1
            else:
                break

        return result