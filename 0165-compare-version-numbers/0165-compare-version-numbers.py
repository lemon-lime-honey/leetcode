class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = list(map(int, version1.split('.')))
        v2 = list(map(int, version2.split('.')))

        idx = 0

        while idx < len(v1) and idx < len(v2):
            if v1[idx] < v2[idx]:
                return -1
            elif v1[idx] > v2[idx]:
                return 1
            idx += 1

        while idx < len(v1):
            if v1[idx] != 0:
                return 1
            idx += 1

        while idx < len(v2):
            if v2[idx] != 0:
                return -1
            idx += 1

        return 0