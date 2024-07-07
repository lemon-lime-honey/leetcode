class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        result = numBottles

        while numBottles >= numExchange:
            empty = numBottles % numExchange
            numBottles = numBottles // numExchange
            result += numBottles
            numBottles += empty

        return result