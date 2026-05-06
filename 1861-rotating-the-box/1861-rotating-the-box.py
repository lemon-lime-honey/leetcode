class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        for i in range(len(boxGrid)):
            idx = len(boxGrid[0]) - 1
            for j in range(len(boxGrid[0]) - 1, -1, -1):
                if boxGrid[i][j] == "*":
                    idx = j - 1
                elif boxGrid[i][j] == "#":
                    boxGrid[i][j], boxGrid[i][idx] = boxGrid[i][idx], boxGrid[i][j]
                    idx -= 1

        result = [[None for i in range(len(boxGrid))] for j in range(len(boxGrid[0]))]

        for i in range(len(boxGrid)):
            for j in range(len(boxGrid[0])):
                result[j][len(boxGrid) - 1 - i] = boxGrid[i][j]

        return result