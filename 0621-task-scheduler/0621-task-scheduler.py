class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        cnt = Counter(tasks)
        cnt_sorted = [x[1] for x in cnt.most_common()]
        most = 0

        for i in range(len(cnt_sorted)):
            if cnt_sorted[i] == cnt_sorted[0]:
                most += 1
            else:
                break

        result = (cnt_sorted[0] - 1) * (n + 1) + most

        return max(result, len(tasks))