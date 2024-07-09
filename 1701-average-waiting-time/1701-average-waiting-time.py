class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        time = customers[0][0]
        total = 0

        for a, p in customers:
            if time <= a:
                total += p
                time = a + p
            else:
                total += time + p - a
                time += p

        return total / len(customers)
