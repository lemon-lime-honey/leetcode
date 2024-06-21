class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        s = 0
        for i in range(len(grumpy)):
            if grumpy[i] == 0: s += customers[i]
            customers[i] *= grumpy[i]

        lo, hi = 0, minutes - 1
        total = sum(customers[:minutes])
        now = total

        while hi < len(customers) - 1:
            now -= customers[lo]
            now += customers[hi + 1]
            lo += 1
            hi += 1
            if total < now: total = now

        return s + total