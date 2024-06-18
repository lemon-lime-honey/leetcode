class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        d = list()
        data = dict()
        result = 0

        for i in range(len(profit)):
            if difficulty[i] not in data:
                d.append(difficulty[i])
                data[difficulty[i]] = profit[i]
            elif data[difficulty[i]] < profit[i]:
                data[difficulty[i]] = profit[i]

        d.sort()
        mProfit = 0

        for i in range(len(d)):
            mProfit = max(mProfit, data[d[i]])
            data[d[i]] = mProfit

        for w in worker:
            lo, hi = 0, len(d) - 1
            while lo <= hi:
                mid = (lo + hi) // 2
                if d[mid] <= w:
                    lo = mid + 1
                else:
                    hi = mid - 1
            if hi >= 0: result += data[d[hi]]

        return result