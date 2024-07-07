class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        while (numBottles >= numExchange) {
            int empty = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            result += numBottles;
            numBottles += empty;
        }

        return result;
    }
}