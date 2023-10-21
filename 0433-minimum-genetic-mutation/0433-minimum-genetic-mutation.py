from collections import deque


class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        if endGene not in bank: return -1

        que = deque([(startGene, 0)])
        chk = dict()

        for seq in bank:
            chk[seq] = False

        while que:
            gene, step = que.popleft()
            if gene == endGene: return step

            for i in range(len(gene)):
                for base in ('A', 'T', 'G', 'C'):
                    if gene[i] != base:
                        nextGene = gene[:i] + base + gene[i + 1:]
                        if nextGene in chk and not chk[nextGene]:
                            que.append((nextGene, step + 1))
                            chk[nextGene] = True

        return -1